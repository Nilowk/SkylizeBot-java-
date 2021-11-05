package fr.nilowk.bot.commands;

import fr.nilowk.bot.Main;
import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import fr.nilowk.bot.utils.utils.UtilsManager;
import org.javacord.api.entity.Permissionable;
import org.javacord.api.entity.channel.ChannelCategory;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.channel.ServerTextChannelBuilder;
import org.javacord.api.entity.channel.ServerVoiceChannelBuilder;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.permission.Permissions;
import org.javacord.api.entity.permission.PermissionsBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Optional;

public class CommandNew implements CommandExecutor {

    private static Optional<Server> server = Main.api.getServerById("793504580217339974");

    public static Optional<ChannelCategory> stat = server.get().getChannelCategoryById("812620778527784960");

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {

        event.getMessage().delete();

        new ServerTextChannelBuilder(event.getServer().get())
                .setName("🧾" + "ticket de " + event.getMessageAuthor().getName() + "🧾")
                .addPermissionOverwrite(server.get().getEveryoneRole(), new PermissionsBuilder().setDenied(PermissionType.READ_MESSAGES).build())
                .addPermissionOverwrite(server.get().getMemberById(event.getMessageAuthor().getId()).get(), new PermissionsBuilder().setAllowed(PermissionType.READ_MESSAGES).build())
                .setCategory(event.getServer().get().getChannelCategoryById("812620778527784960").get())
                .create().thenAcceptAsync(serverTextChannel -> {
                    MessageUtils.sendAndDelete(event.getChannel(), "votre ticket à été crée ici ->", 30_000);
                    event.getChannel().sendMessage(serverTextChannel.getMentionTag()).thenAcceptAsync(message -> {
                        try {
                            Thread.sleep(30_000);
                            message.delete();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    MessageUtils.sendAndDelete(serverTextChannel, "Merci de nous décrire votre problème", 60_000);
        });

    }

}
