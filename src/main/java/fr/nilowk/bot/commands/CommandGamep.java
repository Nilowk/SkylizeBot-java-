package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandGamep implements CommandExecutor {

    private static int number;
    public static int Case;

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();
        if (CommandGamep4.nump >= 1) {
            if (CommandGamep4.nump >= 2) {

                if (event.getChannel().getId() == CommandGamep4.cha) {

                    if (CommandGamep4.tour == 0 || CommandGamep4.tour == 2 || CommandGamep4.tour == 4 || CommandGamep4.tour == 6 || CommandGamep4.tour == 8 || CommandGamep4.tour == 10 || CommandGamep4.tour == 12 || CommandGamep4.tour == 14 || CommandGamep4.tour == 16 || CommandGamep4.tour == 18 || CommandGamep4.tour == 20 || CommandGamep4.tour == 22 || CommandGamep4.tour == 24 || CommandGamep4.tour == 26 || CommandGamep4.tour == 28 || CommandGamep4.tour == 30 || CommandGamep4.tour == 32 || CommandGamep4.tour == 34 || CommandGamep4.tour == 36 || CommandGamep4.tour == 38 || CommandGamep4.tour == 40) {
                        if (args.length < 1) {
                            MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -gamep    numéro_de_la_colone", 10_000);
                        } else if (args.length > 1) {
                            MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -gamep    numéro_de_la_colone", 10_000);
                        } else if (args.length == 1) {
                            try {
                                number = Integer.parseInt(args[0]);
                                if (number < 1 || number > 7) {
                                    MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir des nombres compris entre 1 et 7", 10_000);
                                } else {
                                    if (CommandGamep4.jeu[0][number - 1].equalsIgnoreCase("   ")) {
                                        CommandGamep4.tour++;
                                        getCase();
                                        CommandGamep4.jeu[Case][number - 1] = "X";
                                        if (CommandGamep4.chan != 0) {
                                            event.getChannel().sendMessage("- 1     2    3     4   5    6    7");
                                            event.getChannel().sendMessage("- |      |     |      |     |     |     |");
                                            event.getChannel().sendMessage("[" + CommandGamep4.jeu[0][0] + "][" + CommandGamep4.jeu[0][1] + "][" + CommandGamep4.jeu[0][2] + "][" + CommandGamep4.jeu[0][3] + "][" + CommandGamep4.jeu[0][4] + "][" + CommandGamep4.jeu[0][5] + "][" + CommandGamep4.jeu[0][6] + "]");
                                            event.getChannel().sendMessage("[" + CommandGamep4.jeu[1][0] + "][" + CommandGamep4.jeu[1][1] + "][" + CommandGamep4.jeu[1][2] + "][" + CommandGamep4.jeu[1][3] + "][" + CommandGamep4.jeu[1][4] + "][" + CommandGamep4.jeu[1][5] + "][" + CommandGamep4.jeu[1][6] + "]");
                                            event.getChannel().sendMessage("[" + CommandGamep4.jeu[2][0] + "][" + CommandGamep4.jeu[2][1] + "][" + CommandGamep4.jeu[2][2] + "][" + CommandGamep4.jeu[2][3] + "][" + CommandGamep4.jeu[2][4] + "][" + CommandGamep4.jeu[2][5] + "][" + CommandGamep4.jeu[2][6] + "]");
                                            event.getChannel().sendMessage("[" + CommandGamep4.jeu[3][0] + "][" + CommandGamep4.jeu[3][1] + "][" + CommandGamep4.jeu[3][2] + "][" + CommandGamep4.jeu[3][3] + "][" + CommandGamep4.jeu[3][4] + "][" + CommandGamep4.jeu[3][5] + "][" + CommandGamep4.jeu[3][6] + "]");
                                            event.getChannel().sendMessage("[" + CommandGamep4.jeu[4][0] + "][" + CommandGamep4.jeu[4][1] + "][" + CommandGamep4.jeu[4][2] + "][" + CommandGamep4.jeu[4][3] + "][" + CommandGamep4.jeu[4][4] + "][" + CommandGamep4.jeu[4][5] + "][" + CommandGamep4.jeu[4][6] + "]");
                                            event.getChannel().sendMessage("[" + CommandGamep4.jeu[5][0] + "][" + CommandGamep4.jeu[5][1] + "][" + CommandGamep4.jeu[5][2] + "][" + CommandGamep4.jeu[5][3] + "][" + CommandGamep4.jeu[5][4] + "][" + CommandGamep4.jeu[5][5] + "][" + CommandGamep4.jeu[5][6] + "]");
                                            event.getChannel().sendMessage("Vous venez de jouer, c'est a votre adversaire");
                                            event.getServer().get().getTextChannelById(CommandGamep4.chan).get().sendMessage("- 1     2    3     4   5    6    7");
                                            event.getServer().get().getTextChannelById(CommandGamep4.chan).get().sendMessage("- |      |     |      |     |     |     |");
                                            event.getServer().get().getTextChannelById(CommandGamep4.chan).get().sendMessage("[" + CommandGamep4.jeu[0][0] + "][" + CommandGamep4.jeu[0][1] + "][" + CommandGamep4.jeu[0][2] + "][" + CommandGamep4.jeu[0][3] + "][" + CommandGamep4.jeu[0][4] + "][" + CommandGamep4.jeu[0][5] + "][" + CommandGamep4.jeu[0][6] + "]");
                                            event.getServer().get().getTextChannelById(CommandGamep4.chan).get().sendMessage("[" + CommandGamep4.jeu[1][0] + "][" + CommandGamep4.jeu[1][1] + "][" + CommandGamep4.jeu[1][2] + "][" + CommandGamep4.jeu[1][3] + "][" + CommandGamep4.jeu[1][4] + "][" + CommandGamep4.jeu[1][5] + "][" + CommandGamep4.jeu[1][6] + "]");
                                            event.getServer().get().getTextChannelById(CommandGamep4.chan).get().sendMessage("[" + CommandGamep4.jeu[2][0] + "][" + CommandGamep4.jeu[2][1] + "][" + CommandGamep4.jeu[2][2] + "][" + CommandGamep4.jeu[2][3] + "][" + CommandGamep4.jeu[2][4] + "][" + CommandGamep4.jeu[2][5] + "][" + CommandGamep4.jeu[2][6] + "]");
                                            event.getServer().get().getTextChannelById(CommandGamep4.chan).get().sendMessage("[" + CommandGamep4.jeu[3][0] + "][" + CommandGamep4.jeu[3][1] + "][" + CommandGamep4.jeu[3][2] + "][" + CommandGamep4.jeu[3][3] + "][" + CommandGamep4.jeu[3][4] + "][" + CommandGamep4.jeu[3][5] + "][" + CommandGamep4.jeu[3][6] + "]");
                                            event.getServer().get().getTextChannelById(CommandGamep4.chan).get().sendMessage("[" + CommandGamep4.jeu[4][0] + "][" + CommandGamep4.jeu[4][1] + "][" + CommandGamep4.jeu[4][2] + "][" + CommandGamep4.jeu[4][3] + "][" + CommandGamep4.jeu[4][4] + "][" + CommandGamep4.jeu[4][5] + "][" + CommandGamep4.jeu[4][6] + "]");
                                            event.getServer().get().getTextChannelById(CommandGamep4.chan).get().sendMessage("[" + CommandGamep4.jeu[5][0] + "][" + CommandGamep4.jeu[5][1] + "][" + CommandGamep4.jeu[5][2] + "][" + CommandGamep4.jeu[5][3] + "][" + CommandGamep4.jeu[5][4] + "][" + CommandGamep4.jeu[5][5] + "][" + CommandGamep4.jeu[5][6] + "]");
                                        }
                                    } else {
                                        MessageUtils.sendAndDelete(event.getChannel(), "cette colone est déjà pleine", 10_000);
                                    }
                                }

                            } catch (NumberFormatException e) {
                                MessageUtils.sendAndDelete(event.getChannel(), "veuillez choisir des nombres corrects compris entre 1 et 7", 10_000);
                            }

                        }
                    } else if (CommandGamep4.tour != 42) {
                        MessageUtils.sendAndDelete(event.getChannel(), "ce n'est pas à vous votre adversaire n'a pas encore joué", 10_000);
                    } else {

                    }

                }

                if (event.getChannel().getId() == CommandGamep4.chan) {

                    if (CommandGamep4.tour == 1 || CommandGamep4.tour == 3 || CommandGamep4.tour == 5 || CommandGamep4.tour == 7 || CommandGamep4.tour == 9 || CommandGamep4.tour == 11 || CommandGamep4.tour == 13 || CommandGamep4.tour == 15 || CommandGamep4.tour == 17 || CommandGamep4.tour == 19 || CommandGamep4.tour == 21 || CommandGamep4.tour == 23 || CommandGamep4.tour == 25 || CommandGamep4.tour == 27 || CommandGamep4.tour == 29 || CommandGamep4.tour == 31 || CommandGamep4.tour == 33 || CommandGamep4.tour == 35 || CommandGamep4.tour == 37 || CommandGamep4.tour == 39 || CommandGamep4.tour == 41) {
                        if (args.length < 1) {
                            MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -gamep    numéro_de_la_colone", 10_000);
                        } else if (args.length > 1) {
                            MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -gamep    numéro_de_la_colone", 10_000);
                        } else if (args.length == 1) {
                            try {
                                number = Integer.parseInt(args[0]);
                                if (number < 1 || number > 7) {
                                    MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir un nombre compris entre 1 et 7", 10_000);
                                } else {
                                    if (CommandGamep4.jeu[0][number - 1].equalsIgnoreCase("   ")) {
                                        CommandGamep4.tour++;
                                        getCase();
                                        CommandGamep4.jeu[Case][number - 1] = "O";
                                        event.getChannel().sendMessage("- 1     2    3     4   5    6    7");
                                        event.getChannel().sendMessage("- |      |     |      |     |     |     |");
                                        event.getChannel().sendMessage("[" + CommandGamep4.jeu[0][0] + "][" + CommandGamep4.jeu[0][1] + "][" + CommandGamep4.jeu[0][2] + "][" + CommandGamep4.jeu[0][3] + "][" + CommandGamep4.jeu[0][4] + "][" + CommandGamep4.jeu[0][5] + "][" + CommandGamep4.jeu[0][6] + "]");
                                        event.getChannel().sendMessage("[" + CommandGamep4.jeu[1][0] + "][" + CommandGamep4.jeu[1][1] + "][" + CommandGamep4.jeu[1][2] + "][" + CommandGamep4.jeu[1][3] + "][" + CommandGamep4.jeu[1][4] + "][" + CommandGamep4.jeu[1][5] + "][" + CommandGamep4.jeu[1][6] + "]");
                                        event.getChannel().sendMessage("[" + CommandGamep4.jeu[2][0] + "][" + CommandGamep4.jeu[2][1] + "][" + CommandGamep4.jeu[2][2] + "][" + CommandGamep4.jeu[2][3] + "][" + CommandGamep4.jeu[2][4] + "][" + CommandGamep4.jeu[2][5] + "][" + CommandGamep4.jeu[2][6] + "]");
                                        event.getChannel().sendMessage("[" + CommandGamep4.jeu[3][0] + "][" + CommandGamep4.jeu[3][1] + "][" + CommandGamep4.jeu[3][2] + "][" + CommandGamep4.jeu[3][3] + "][" + CommandGamep4.jeu[3][4] + "][" + CommandGamep4.jeu[3][5] + "][" + CommandGamep4.jeu[3][6] + "]");
                                        event.getChannel().sendMessage("[" + CommandGamep4.jeu[4][0] + "][" + CommandGamep4.jeu[4][1] + "][" + CommandGamep4.jeu[4][2] + "][" + CommandGamep4.jeu[4][3] + "][" + CommandGamep4.jeu[4][4] + "][" + CommandGamep4.jeu[4][5] + "][" + CommandGamep4.jeu[4][6] + "]");
                                        event.getChannel().sendMessage("[" + CommandGamep4.jeu[5][0] + "][" + CommandGamep4.jeu[5][1] + "][" + CommandGamep4.jeu[5][2] + "][" + CommandGamep4.jeu[5][3] + "][" + CommandGamep4.jeu[5][4] + "][" + CommandGamep4.jeu[5][5] + "][" + CommandGamep4.jeu[5][6] + "]");
                                        event.getChannel().sendMessage("Vous venez de jouer, c'est a votre adversaire");
                                        event.getServer().get().getTextChannelById(CommandGamep4.cha).get().sendMessage("- 1     2    3     4   5    6    7");
                                        event.getServer().get().getTextChannelById(CommandGamep4.cha).get().sendMessage("- |      |     |      |     |     |     |");
                                        event.getServer().get().getTextChannelById(CommandGamep4.cha).get().sendMessage("[" + CommandGamep4.jeu[0][0] + "][" + CommandGamep4.jeu[0][1] + "][" + CommandGamep4.jeu[0][2] + "][" + CommandGamep4.jeu[0][3] + "][" + CommandGamep4.jeu[0][4] + "][" + CommandGamep4.jeu[0][5] + "][" + CommandGamep4.jeu[0][6] + "]");
                                        event.getServer().get().getTextChannelById(CommandGamep4.cha).get().sendMessage("[" + CommandGamep4.jeu[1][0] + "][" + CommandGamep4.jeu[1][1] + "][" + CommandGamep4.jeu[1][2] + "][" + CommandGamep4.jeu[1][3] + "][" + CommandGamep4.jeu[1][4] + "][" + CommandGamep4.jeu[1][5] + "][" + CommandGamep4.jeu[1][6] + "]");
                                        event.getServer().get().getTextChannelById(CommandGamep4.cha).get().sendMessage("[" + CommandGamep4.jeu[2][0] + "][" + CommandGamep4.jeu[2][1] + "][" + CommandGamep4.jeu[2][2] + "][" + CommandGamep4.jeu[2][3] + "][" + CommandGamep4.jeu[2][4] + "][" + CommandGamep4.jeu[2][5] + "][" + CommandGamep4.jeu[2][6] + "]");
                                        event.getServer().get().getTextChannelById(CommandGamep4.cha).get().sendMessage("[" + CommandGamep4.jeu[3][0] + "][" + CommandGamep4.jeu[3][1] + "][" + CommandGamep4.jeu[3][2] + "][" + CommandGamep4.jeu[3][3] + "][" + CommandGamep4.jeu[3][4] + "][" + CommandGamep4.jeu[3][5] + "][" + CommandGamep4.jeu[3][6] + "]");
                                        event.getServer().get().getTextChannelById(CommandGamep4.cha).get().sendMessage("[" + CommandGamep4.jeu[4][0] + "][" + CommandGamep4.jeu[4][1] + "][" + CommandGamep4.jeu[4][2] + "][" + CommandGamep4.jeu[4][3] + "][" + CommandGamep4.jeu[4][4] + "][" + CommandGamep4.jeu[4][5] + "][" + CommandGamep4.jeu[4][6] + "]");
                                        event.getServer().get().getTextChannelById(CommandGamep4.cha).get().sendMessage("[" + CommandGamep4.jeu[5][0] + "][" + CommandGamep4.jeu[5][1] + "][" + CommandGamep4.jeu[5][2] + "][" + CommandGamep4.jeu[5][3] + "][" + CommandGamep4.jeu[5][4] + "][" + CommandGamep4.jeu[5][5] + "][" + CommandGamep4.jeu[5][6] + "]");
                                    } else {
                                        MessageUtils.sendAndDelete(event.getChannel(), "cette colone est déjà pleine", 10_000);
                                    }
                                }

                            } catch (NumberFormatException e) {
                                MessageUtils.sendAndDelete(event.getChannel(), "veuillez choisir des nombres corrects compris entre 1 et 7", 10_000);
                            }

                        }
                    } else {
                        MessageUtils.sendAndDelete(event.getChannel(), "ce n'est pas à vous votre adversaire n'a pas encore joué", 10_000);
                    }

                }

            } else {
                MessageUtils.sendAndDelete(event.getChannel(), "En attente de joueur", 10_000);
            }
        }
    }

    public static void getCase() {

        if (CommandGamep4.jeu[5][number - 1].equalsIgnoreCase("   ")) {
            Case = 5;
        }
        if (CommandGamep4.jeu[5][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[0][number - 1].equalsIgnoreCase("O")) {
            if (CommandGamep4.jeu[4][number - 1].equalsIgnoreCase("   ")){
                Case = 4;
            }
        }
        if (CommandGamep4.jeu[5][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[0][number - 1].equalsIgnoreCase("O")) {
            if (CommandGamep4.jeu[4][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[4][number - 1].equalsIgnoreCase("O")){
                if (CommandGamep4.jeu[3][number - 1].equalsIgnoreCase("   ")){
                    Case = 3;
                }
            }
        }
        if (CommandGamep4.jeu[5][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[0][number - 1].equalsIgnoreCase("O")) {
            if (CommandGamep4.jeu[4][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[4][number - 1].equalsIgnoreCase("O")){
                if (CommandGamep4.jeu[3][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[3][number - 1].equalsIgnoreCase("O")){
                    if (CommandGamep4.jeu[2][number - 1].equalsIgnoreCase("   ")){
                        Case = 2;
                    }
                }
            }
        }
        if (CommandGamep4.jeu[5][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[0][number - 1].equalsIgnoreCase("O")) {
            if (CommandGamep4.jeu[4][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[4][number - 1].equalsIgnoreCase("O")){
                if (CommandGamep4.jeu[3][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[3][number - 1].equalsIgnoreCase("O")){
                    if (CommandGamep4.jeu[2][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[2][number - 1].equalsIgnoreCase("O")){
                        if (CommandGamep4.jeu[1][number - 1].equalsIgnoreCase("   ")){
                            Case = 1;
                        }
                    }
                }
            }
        }
        if (CommandGamep4.jeu[5][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[0][number - 1].equalsIgnoreCase("O")) {
            if (CommandGamep4.jeu[4][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[4][number - 1].equalsIgnoreCase("O")){
                if (CommandGamep4.jeu[3][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[3][number - 1].equalsIgnoreCase("O")){
                    if (CommandGamep4.jeu[2][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[2][number - 1].equalsIgnoreCase("O")){
                        if (CommandGamep4.jeu[1][number - 1].equalsIgnoreCase("X") || CommandGamep4.jeu[1][number - 1].equalsIgnoreCase("O")){
                            if (CommandGamep4.jeu[0][number - 1].equalsIgnoreCase("   ")) {
                                Case = 0;
                            }
                        }
                    }
                }
            }
        }

    }

    public static void getWiner() {

        if (Case <= 5){
            if (CommandGamep4.jeu[Case - 1][number - 1].equalsIgnoreCase("X")) {
                if (CommandGamep4.jeu[Case - 2][number - 1].equalsIgnoreCase("X")) {
                    if (CommandGamep4.jeu[Case - 3][number -1].equalsIgnoreCase("X")) {
                        CommandGamep4.getWinerX();
                    }
                }
            }
            if (CommandGamep4.jeu[Case - 1][number - 1].equalsIgnoreCase("O")) {
                if (CommandGamep4.jeu[Case - 2][number - 1].equalsIgnoreCase("O")) {
                    if (CommandGamep4.jeu[Case - 3][number -1].equalsIgnoreCase("O")) {
                        CommandGamep4.getWinerO();
                    }
                }
            }
        }

    }

}
