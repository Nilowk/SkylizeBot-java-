package fr.nilowk.bot.utils.utils;

import fr.nilowk.bot.Main;
import org.javacord.api.entity.channel.ChannelCategory;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.entity.channel.ServerVoiceChannelBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.UserStatus;
import org.javacord.api.event.server.member.ServerMemberJoinEvent;
import org.javacord.api.event.server.member.ServerMemberLeaveEvent;
import org.javacord.api.event.user.UserChangeStatusEvent;

import java.util.Optional;

public class Statistique {

    public static long id = 0;

    public static long id1 = 0;

    public static long id2 = 0;

    public static long id3 = 0;

    private static Optional<ServerVoiceChannel> a;

    private static Optional<ServerVoiceChannel> b;

    private static Optional<ServerVoiceChannel> c;

    private static Optional<ServerVoiceChannel> d;

    private static Optional<Server> server = Main.api.getServerById("793504580217339974");

    public static Optional<ChannelCategory> stat = server.get().getChannelCategoryById("812301065696837633");

    public static void join(ServerMemberJoinEvent event) {

        Optional<ServerTextChannel> caca = server.get().getTextChannelById("794584761007734784");

        caca.get().sendMessage(event.getUser().getMentionTag() + " a rejoint le serveur, nous sommes désormais " + event.getServer().getMemberCount() + " citoyen dans cette ville, merci a toi ! 🎉");

    }

    public static void leave(ServerMemberLeaveEvent event) {

        Optional<ServerTextChannel> caca = server.get().getTextChannelById("794584761007734784");

        caca.get().sendMessage(event.getUser().getMentionTag() + " a quitté le serveur... :cry:");

    }

    public static void statCountMembers(ServerMemberJoinEvent event) {

        regenerateMembersChannel();

    }

    public static void statCountMember(ServerMemberLeaveEvent event) {

        regenerateMembersChannel();

    }

    public static void regenerateMembersChannel() {

        a = server.get().getVoiceChannelById(id);
        if (a.isPresent()) {
            a.get().delete();
        }
        new ServerVoiceChannelBuilder(server.get())
                .setName("📈Membre : " + server.get().getMemberCount() + " membres")
                .setCategory(stat.get())
                .create().thenAcceptAsync(channel -> {
            id = channel.getId();
        });

    }

    public static void statCountBots(ServerMemberJoinEvent event) {

        regenerateBotsChannel();

    }

    public static void statCountBot(ServerMemberLeaveEvent event) {

        regenerateBotsChannel();

    }

    public static long getCountBots() {
        long pipi = server.get().getMembers().stream().filter(user -> user.isBot()).count();
        return pipi;
    }

    public static void regenerateBotsChannel() {

        b = server.get().getVoiceChannelById(id1);
        if (b.isPresent()) {
            b.get().delete();
        }
        new ServerVoiceChannelBuilder(server.get())
                .setName("🤖Bot : " + getCountBots() + " bots")
                .setCategory(stat.get())
                .create().thenAcceptAsync(channel -> {
            id1 = channel.getId();
        });

    }

    public static void statCountCitoyens(ServerMemberJoinEvent event) {

        regenerateCitoyensChannel();

    }

    public static void statCountCitoyen(ServerMemberLeaveEvent event) {

        regenerateCitoyensChannel();

    }

    public static void regenerateCitoyensChannel() {

        int membersCount = server.get().getMemberCount();
        long calcule = membersCount - getCountBots();

        c = server.get().getVoiceChannelById(id2);
        if (c.isPresent()) {
            c.get().delete();
        }
        new ServerVoiceChannelBuilder(server.get())
                .setName("🧑citoyen : " + calcule + " citoyens")
                .setCategory(stat.get())
                .create().thenAcceptAsync(channel -> {
            id2 = channel.getId();
        });

    }

    public static void statCountOnlines(UserChangeStatusEvent event) {

        regenerateOnlinesChannel();

        long countChannel = server.get().getChannelCategoryById("812301065696837633").get().getChannels().size();

        if (countChannel > 4) {
            server.get().getTextChannelById("814571822736867368").get().sendMessage("-cstats");
            server.get().getTextChannelById("814571822736867368").get().sendMessage("-rstats");
        }

    }

    public static long getCountOnlines() {

        var pipi = server.get().getMembers().stream().filter(user -> user.getStatus() != UserStatus.OFFLINE).count();
        return pipi;

    }

    public static void regenerateOnlinesChannel() {

        long calcule = getCountOnlines() - getCountBots();

        d = server.get().getVoiceChannelById(id3);
        if (d.isPresent()) {
            d.get().delete();
        }
        new ServerVoiceChannelBuilder(server.get())
                .setName("📌En ligne : " + calcule + " citoyens")
                .setCategory(stat.get())
                .create().thenAcceptAsync(channel -> {
            id3 = channel.getId();
        });

    }
}
