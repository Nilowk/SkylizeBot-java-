package fr.nilowk.bot.commands;

import fr.nilowk.bot.Main;
import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.channel.ServerTextChannelBuilder;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.permission.PermissionsBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandGamep4 implements CommandExecutor {

    public static int tour = 0;

    public static long cha = 0;
    public static long chan = 0;

    public static String player1 = "";
    public static String player2 = "";

    public static int nump = 0;
    public static String[][] jeu = {
            {"   ", "   ", "   ", "   ", "   ", "   ", "   "},
            {"   ", "   ", "   ", "   ", "   ", "   ", "   "},
            {"   ", "   ", "   ", "   ", "   ", "   ", "   "},
            {"   ", "   ", "   ", "   ", "   ", "   ", "   "},
            {"   ", "   ", "   ", "   ", "   ", "   ", "   "},
            {"   ", "   ", "   ", "   ", "   ", "   ", "   "}
    };

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();
        nump++;

        System.out.println(jeu[5][0]);

        if (nump < 2) {

            new ServerTextChannelBuilder(event.getServer().get())
                    .setName("🥊 " + event.getMessageAuthor().getName() + " / p4 🥊")
                    .setCategory(event.getServer().get().getChannelCategoryById("820292075048009778").get())
                    .addPermissionOverwrite(event.getMessageAuthor().asUser().get(), new PermissionsBuilder().setAllowed(PermissionType.READ_MESSAGES).build())
                    .addPermissionOverwrite(event.getServer().get().getEveryoneRole(), new PermissionsBuilder().setDenied(PermissionType.READ_MESSAGES).build())
                    .create().thenAcceptAsync(channel -> {
                cha = channel.getId();
                channel.sendMessage("puissance 4 :");
                channel.sendMessage("Pour se jeu les règles sont simple, il vous suffit de choisir la colone dans la quelle le pion tombe, le but étant d'aligner 4 pions :");
                channel.sendMessage("pour jouer utiliser : -gamep    numéro_de_colone, vous êtes les croix");
                channel.sendMessage("- 1     2    3     4   5    6    7");
                channel.sendMessage("- |      |     |      |     |     |     |");
                channel.sendMessage("[" + jeu[0][0] + "][" + jeu[0][1] + "][" + jeu[0][2] + "][" + jeu[0][3] + "][" + jeu[0][4] + "][" + jeu[0][5] + "][" + jeu[0][6] + "]");
                channel.sendMessage("[" + jeu[1][0] + "][" + jeu[1][1] + "][" + jeu[1][2] + "][" + jeu[1][3] + "][" + jeu[1][4] + "][" + jeu[1][5] + "][" + jeu[1][6] + "]");
                channel.sendMessage("[" + jeu[2][0] + "][" + jeu[2][1] + "][" + jeu[2][2] + "][" + jeu[2][3] + "][" + jeu[2][4] + "][" + jeu[2][5] + "][" + jeu[2][6] + "]");
                channel.sendMessage("[" + jeu[3][0] + "][" + jeu[3][1] + "][" + jeu[3][2] + "][" + jeu[3][3] + "][" + jeu[3][4] + "][" + jeu[3][5] + "][" + jeu[3][6] + "]");
                channel.sendMessage("[" + jeu[4][0] + "][" + jeu[4][1] + "][" + jeu[4][2] + "][" + jeu[4][3] + "][" + jeu[4][4] + "][" + jeu[4][5] + "][" + jeu[4][6] + "]");
                channel.sendMessage("[" + jeu[5][0] + "][" + jeu[5][1] + "][" + jeu[5][2] + "][" + jeu[5][3] + "][" + jeu[5][4] + "][" + jeu[5][5] + "][" + jeu[5][6] + "]");
                MessageUtils.sendAndDelete(event.getChannel(), "le jeux se passe dans ce channel -> ", 10_000);
                event.getChannel().sendMessage(channel.getMentionTag()).thenAcceptAsync(message -> {
                    try {
                        Thread.sleep(10_000);
                        message.delete();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            });
            player1 = event.getMessageAuthor().asUser().get().getMentionTag();

        }
        if (nump == 2) {
            new ServerTextChannelBuilder(event.getServer().get())
                    .setName("🥊 " + event.getMessageAuthor().getName() + " / p4 🥊")
                    .setCategory(event.getServer().get().getChannelCategoryById("820292075048009778").get())
                    .addPermissionOverwrite(event.getMessageAuthor().asUser().get(), new PermissionsBuilder().setAllowed(PermissionType.READ_MESSAGES).build())
                    .addPermissionOverwrite(event.getServer().get().getEveryoneRole(), new PermissionsBuilder().setDenied(PermissionType.READ_MESSAGES).build())
                    .create().thenAcceptAsync(channel -> {
                chan = channel.getId();
                channel.sendMessage("puissance 4 :");
                channel.sendMessage("Pour se jeu les règles sont simple, il vous suffit de choisir la colone dans la quelle le pion tombe, le but étant d'aligner 4 pions :");
                channel.sendMessage("pour jouer utiliser : -gamep    numéro_de_la_colone, vous êtes les ronds");
                channel.sendMessage("- 1     2    3     4   5    6    7");
                channel.sendMessage("- |      |     |      |     |     |     |");
                channel.sendMessage("[" + jeu[0][0] + "][" + jeu[0][1] + "][" + jeu[0][2] + "][" + jeu[0][3] + "][" + jeu[0][4] + "][" + jeu[0][5] + "][" + jeu[0][6] + "]");
                channel.sendMessage("[" + jeu[1][0] + "][" + jeu[1][1] + "][" + jeu[1][2] + "][" + jeu[1][3] + "][" + jeu[1][4] + "][" + jeu[1][5] + "][" + jeu[1][6] + "]");
                channel.sendMessage("[" + jeu[2][0] + "][" + jeu[2][1] + "][" + jeu[2][2] + "][" + jeu[2][3] + "][" + jeu[2][4] + "][" + jeu[2][5] + "][" + jeu[2][6] + "]");
                channel.sendMessage("[" + jeu[3][0] + "][" + jeu[3][1] + "][" + jeu[3][2] + "][" + jeu[3][3] + "][" + jeu[3][4] + "][" + jeu[3][5] + "][" + jeu[3][6] + "]");
                channel.sendMessage("[" + jeu[4][0] + "][" + jeu[4][1] + "][" + jeu[4][2] + "][" + jeu[4][3] + "][" + jeu[4][4] + "][" + jeu[4][5] + "][" + jeu[4][6] + "]");
                channel.sendMessage("[" + jeu[5][0] + "][" + jeu[5][1] + "][" + jeu[5][2] + "][" + jeu[5][3] + "][" + jeu[5][4] + "][" + jeu[5][5] + "][" + jeu[5][6] + "]");
                MessageUtils.sendAndDelete(event.getChannel(), "le jeux se passe dans ce channel -> ", 10_000);
                event.getChannel().sendMessage(channel.getMentionTag()).thenAcceptAsync(message -> {
                    try {
                        Thread.sleep(10_000);
                        message.delete();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            });
            event.getServer().get().getTextChannelById(cha).get().sendMessage(player1 + " Vous êtes deux joueurs la partie peu commencer, c'est à vous de commencer");
            player2 = event.getMessageAuthor().asUser().get().getMentionTag();
            try {
                Thread.sleep(100);
                event.getServer().get().getTextChannelById(chan).get().sendMessage(player2 + " Vous êtes deux joueurs la partie peu commencer, c'est à l'adversaire de commencer");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        if (nump >= 3) {
            MessageUtils.sendAndDelete(event.getChannel(), "Une partie de morpion est déjà en cour", 10_000);
        }
    }

    public static void getWinerX() {

        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage(player1 + " a gagné la partie il était les croix");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage(player1 + ": X || " + player2 + ": O");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage("[" + jeu[0][0] + "][" + jeu[0][1] + "][" + jeu[0][2] + "][" + jeu[0][3] + "][" + jeu[0][4] + "][" + jeu[0][5] + "][" + jeu[0][6] + "]");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage("[" + jeu[1][0] + "][" + jeu[1][1] + "][" + jeu[1][2] + "][" + jeu[1][3] + "][" + jeu[1][4] + "][" + jeu[1][5] + "][" + jeu[1][6] + "]");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage("[" + jeu[2][0] + "][" + jeu[2][1] + "][" + jeu[2][2] + "][" + jeu[2][3] + "][" + jeu[2][4] + "][" + jeu[2][5] + "][" + jeu[2][6] + "]");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage("[" + jeu[3][0] + "][" + jeu[3][1] + "][" + jeu[3][2] + "][" + jeu[3][3] + "][" + jeu[3][4] + "][" + jeu[3][5] + "][" + jeu[3][6] + "]");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage("[" + jeu[4][0] + "][" + jeu[4][1] + "][" + jeu[4][2] + "][" + jeu[4][3] + "][" + jeu[4][4] + "][" + jeu[4][5] + "][" + jeu[4][6] + "]");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage("[" + jeu[5][0] + "][" + jeu[5][1] + "][" + jeu[5][2] + "][" + jeu[5][3] + "][" + jeu[5][4] + "][" + jeu[5][5] + "][" + jeu[5][6] + "]");
        clean();

    }

    public static void getWinerO() {
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage(player2 + " a gagné la partie il était les ronds");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage(player1 + ": X || " + player2 + ": O");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage("[" + jeu[0][0] + "][" + jeu[0][1] + "][" + jeu[0][2] + "][" + jeu[0][3] + "][" + jeu[0][4] + "][" + jeu[0][5] + "][" + jeu[0][6] + "]");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage("[" + jeu[1][0] + "][" + jeu[1][1] + "][" + jeu[1][2] + "][" + jeu[1][3] + "][" + jeu[1][4] + "][" + jeu[1][5] + "][" + jeu[1][6] + "]");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage("[" + jeu[2][0] + "][" + jeu[2][1] + "][" + jeu[2][2] + "][" + jeu[2][3] + "][" + jeu[2][4] + "][" + jeu[2][5] + "][" + jeu[2][6] + "]");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage("[" + jeu[3][0] + "][" + jeu[3][1] + "][" + jeu[3][2] + "][" + jeu[3][3] + "][" + jeu[3][4] + "][" + jeu[3][5] + "][" + jeu[3][6] + "]");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage("[" + jeu[4][0] + "][" + jeu[4][1] + "][" + jeu[4][2] + "][" + jeu[4][3] + "][" + jeu[4][4] + "][" + jeu[4][5] + "][" + jeu[4][6] + "]");
        Main.api.getServerById("793504580217339974").get().getTextChannelById("820666786394669106").get().sendMessage("[" + jeu[5][0] + "][" + jeu[5][1] + "][" + jeu[5][2] + "][" + jeu[5][3] + "][" + jeu[5][4] + "][" + jeu[5][5] + "][" + jeu[5][6] + "]");
        clean();
    }

    public static void clean() {
        tour = 0;

        Main.api.getServerTextChannelById(chan).get().delete();
        Main.api.getServerTextChannelById(cha).get().delete();
        cha = 0;
        chan = 0;

        player1 = "";
        player2 = "";

        nump = 0;
        jeu[0][0] = "   ";
        jeu[0][1] = "   ";
        jeu[0][2] = "   ";
        jeu[0][3] = "   ";
        jeu[0][4] = "   ";
        jeu[0][5] = "   ";
        jeu[0][6] = "   ";
        jeu[1][0] = "   ";
        jeu[1][1] = "   ";
        jeu[1][2] = "   ";
        jeu[1][3] = "   ";
        jeu[1][4] = "   ";
        jeu[1][5] = "   ";
        jeu[1][6] = "   ";
        jeu[2][0] = "   ";
        jeu[2][1] = "   ";
        jeu[2][2] = "   ";
        jeu[2][3] = "   ";
        jeu[2][4] = "   ";
        jeu[2][5] = "   ";
        jeu[2][6] = "   ";
        jeu[3][0] = "   ";
        jeu[3][1] = "   ";
        jeu[3][2] = "   ";
        jeu[3][3] = "   ";
        jeu[3][4] = "   ";
        jeu[3][5] = "   ";
        jeu[3][6] = "   ";
        jeu[4][0] = "   ";
        jeu[4][1] = "   ";
        jeu[4][2] = "   ";
        jeu[4][3] = "   ";
        jeu[4][4] = "   ";
        jeu[4][5] = "   ";
        jeu[4][6] = "   ";
        jeu[5][0] = "   ";
        jeu[5][1] = "   ";
        jeu[5][2] = "   ";
        jeu[5][3] = "   ";
        jeu[5][4] = "   ";
        jeu[5][5] = "   ";
        jeu[5][6] = "   ";

    }
}
