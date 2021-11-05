package fr.nilowk.bot.commands;

import fr.nilowk.bot.Main;
import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.channel.ServerTextChannelBuilder;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.permission.PermissionsBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandGamem implements CommandExecutor {

    public static int tour = 0;

    public static long cha = 0;
    public static long chan = 0;

    public static String player1 = "";
    public static String player2 = "";

    public static int nump = 0;
    public static String[][] jeu = {
            {"   ", "   ", "   "},
            {"   ", "   ", "   "},
            {"   ", "   ", "   "}
    };

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();
        nump++;

        if (nump < 2) {

            new ServerTextChannelBuilder(event.getServer().get())
                    .setName("🥊 " + event.getMessageAuthor().getName() + " / m 🥊")
                    .setCategory(event.getServer().get().getChannelCategoryById("820292075048009778").get())
                    .addPermissionOverwrite(event.getMessageAuthor().asUser().get(), new PermissionsBuilder().setAllowed(PermissionType.READ_MESSAGES).build())
                    .addPermissionOverwrite(event.getServer().get().getEveryoneRole(), new PermissionsBuilder().setDenied(PermissionType.READ_MESSAGES).build())
                    .create().thenAcceptAsync(channel -> {
                cha = channel.getId();
                channel.sendMessage("morpion :");
                channel.sendMessage("Pour se jeu les règles sont simple, il vous suffit de placer votre pion sur un case et d'essayer d'en aligner 3 :");
                channel.sendMessage("pour jouer utiliser : -game     numéro_horizontal_de_la_case    numéro_vertical_de_la_case, vous êtes les croix");
                channel.sendMessage("-          1    2    3");
                channel.sendMessage("-          |     |     |");
                channel.sendMessage("1  -> [" + jeu[0][0] + "][" + jeu[0][1] + "][" + jeu[0][2] + "]");
                channel.sendMessage("2 -> [" + jeu[1][0] + "][" + jeu[1][1] + "][" + jeu[1][2] + "]");
                channel.sendMessage("3 -> [" + jeu[2][0] + "][" + jeu[2][1] + "][" + jeu[2][2] + "]");
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
                    .setName("🥊 " + event.getMessageAuthor().getName() + " / m 🥊")
                    .setCategory(event.getServer().get().getChannelCategoryById("820292075048009778").get())
                    .addPermissionOverwrite(event.getMessageAuthor().asUser().get(), new PermissionsBuilder().setAllowed(PermissionType.READ_MESSAGES).build())
                    .addPermissionOverwrite(event.getServer().get().getEveryoneRole(), new PermissionsBuilder().setDenied(PermissionType.READ_MESSAGES).build())
                    .create().thenAcceptAsync(channel -> {
                chan = channel.getId();
                channel.sendMessage("morpion :");
                channel.sendMessage("Pour se jeu les règles sont simple, il vous suffit de placer votre pion sur un case et d'essayer d'en aligner 3 :");
                channel.sendMessage("pour jouer utiliser : -game     numéro_horizontal_de_la_case    numéro_vertical_de_la_case, vous êtes les ronds");
                channel.sendMessage("-          1    2    3");
                channel.sendMessage("-          |     |     |");
                channel.sendMessage("1  -> [" + jeu[0][0] + "][" + jeu[0][1] + "][" + jeu[0][2] + "]");
                channel.sendMessage("2 -> [" + jeu[1][0] + "][" + jeu[1][1] + "][" + jeu[1][2] + "]");
                channel.sendMessage("3 -> [" + jeu[2][0] + "][" + jeu[2][1] + "][" + jeu[2][2] + "]");
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
            event.getServer().get().getTextChannelById(chan).get().sendMessage(player2 + " Vous êtes deux joueurs la partie peu commencer, c'est à l'adversaire de commencer");
        }

        if (nump >= 3) {
            MessageUtils.sendAndDelete(event.getChannel(), "Une partie de morpion est déjà en cour", 10_000);
        }

    }

    public static void getWinner() {

        if (jeu[0][0].equalsIgnoreCase("X") && jeu[0][1].equalsIgnoreCase("X") && jeu[0][2].equalsIgnoreCase("X")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player1 + " a gagné il était les croix résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[1][0].equalsIgnoreCase("X") && jeu[1][1].equalsIgnoreCase("X") && jeu[1][2].equalsIgnoreCase("X")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player1 + " a gagné il était les croix résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[2][0].equalsIgnoreCase("X") && jeu[2][1].equalsIgnoreCase("X") && jeu[2][2].equalsIgnoreCase("X")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player1 + " a gagné il était les croix résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[0][0].equalsIgnoreCase("X") && jeu[1][0].equalsIgnoreCase("X") && jeu[2][0].equalsIgnoreCase("X")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player1 + " a gagné il était les croix résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[0][1].equalsIgnoreCase("X") && jeu[1][1].equalsIgnoreCase("X") && jeu[2][1].equalsIgnoreCase("X")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player1 + " a gagné il était les croix résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[0][2].equalsIgnoreCase("X") && jeu[1][2].equalsIgnoreCase("X") && jeu[2][2].equalsIgnoreCase("X")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player1 + " a gagné il était les croix résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[0][0].equalsIgnoreCase("X") && jeu[1][1].equalsIgnoreCase("X") && jeu[2][2].equalsIgnoreCase("X")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player1 + " a gagné il était les croix résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[0][2].equalsIgnoreCase("X") && jeu[1][1].equalsIgnoreCase("X") && jeu[2][0].equalsIgnoreCase("X")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player1 + " a gagné il était les croix résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }

        if (jeu[0][0].equalsIgnoreCase("O") && jeu[0][1].equalsIgnoreCase("O") && jeu[0][2].equalsIgnoreCase("O")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player2 + " a gagné il était les ronds résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[1][0].equalsIgnoreCase("O") && jeu[1][1].equalsIgnoreCase("O") && jeu[1][2].equalsIgnoreCase("O")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player2 + " a gagné il était les ronds résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[2][0].equalsIgnoreCase("O") && jeu[2][1].equalsIgnoreCase("O") && jeu[2][2].equalsIgnoreCase("O")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player2 + " a gagné il était les ronds résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[0][0].equalsIgnoreCase("O") && jeu[1][0].equalsIgnoreCase("O") && jeu[2][0].equalsIgnoreCase("O")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player2 + " a gagné il était les ronds résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[0][1].equalsIgnoreCase("O") && jeu[1][1].equalsIgnoreCase("O") && jeu[2][1].equalsIgnoreCase("O")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player2 + " a gagné il était les ronds résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[0][2].equalsIgnoreCase("O") && jeu[1][2].equalsIgnoreCase("O") && jeu[2][2].equalsIgnoreCase("O")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player2 + " a gagné il était les ronds résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[0][0].equalsIgnoreCase("O") && jeu[1][1].equalsIgnoreCase("O") && jeu[2][2].equalsIgnoreCase("O")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player2 + " a gagné il était les ronds résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }
        if (jeu[0][2].equalsIgnoreCase("O") && jeu[1][1].equalsIgnoreCase("O") && jeu[2][0].equalsIgnoreCase("O")) {
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(player2 + " a gagné il était les ronds résultats :");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
            clean();
        }


    }

    public static void clean() {

        Main.api.getServerById("793504580217339974").get().getTextChannelById(cha).get().delete();
        Main.api.getServerById("793504580217339974").get().getTextChannelById(chan).get().delete();

        tour = 0;

        cha = 0;
        chan = 0;

        player1 = "";
        player2 = "";

        nump = 0;
        jeu[0][0] = "   ";
        jeu[0][1] = "   ";
        jeu[0][2] = "   ";
        jeu[1][0] = "   ";
        jeu[1][1] = "   ";
        jeu[1][2] = "   ";
        jeu[2][0] = "   ";
        jeu[2][1] = "   ";
        jeu[2][2] = "   ";

    }

}
