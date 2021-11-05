package fr.nilowk.bot.commands;

import fr.nilowk.bot.Main;
import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandeGame implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();
        if (CommandGamem.nump >= 1) {
            if (CommandGamem.nump >= 2) {
                if (event.getChannel().getId() == CommandGamem.cha) {
                    if (CommandGamem.tour == 0) {
                        if (args.length < 2) {
                            MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                        } else if (args.length > 2) {
                            MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                        } else if (args.length == 2) {
                            try {
                                int number = Integer.parseInt(args[0]);
                                int number2 = Integer.parseInt(args[1]);
                                if (number < 1 || number > 3 || number2 < 1 || number2 > 3) {
                                    MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir des nombres compris entre 1 et 3", 10_000);
                                } else {
                                    if (CommandGamem.jeu[number - 1][number2 - 1].equalsIgnoreCase("   ")){
                                        CommandGamem.tour++;
                                        CommandGamem.jeu[number - 1][number2 - 1] = "X";
                                        event.getChannel().sendMessage("-          1    2    3");
                                        event.getChannel().sendMessage("-          |     |     |");
                                        event.getChannel().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                        event.getChannel().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                        event.getChannel().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                        event.getChannel().sendMessage("Vous venez de jouer, c'est a votre adversaire");
                                        event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("-          1    2    3");
                                        event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("-          |     |     |");
                                        event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                        event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                        event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                        event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("votre adversaire viens de jouer c'est a vous :");

                                    } else {
                                        MessageUtils.sendAndDelete(event.getChannel(), "un pion est déja posé ici", 10_000);
                                    }
                                }
                            } catch (NumberFormatException e) {
                                MessageUtils.sendAndDelete(event.getChannel(), "veuillez choisir des nombres corrects compris entre 1 et 3", 10_000);
                            }

                        }
                    } else {
                        if (CommandGamem.tour == 1) {
                            MessageUtils.sendAndDelete(event.getChannel(), "Votre adversaire n'a pas encore jouer", 10_000);
                        }
                        if (CommandGamem.tour == 2) {
                            if (args.length < 2) {
                                MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                            } else if (args.length > 2) {
                                MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                            } else if (args.length == 2) {
                                try {
                                    int number = Integer.parseInt(args[0]);
                                    int number2 = Integer.parseInt(args[1]);
                                    if (number < 1 || number > 3 || number2 < 1 || number2 > 3) {
                                        MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir des nombres compris entre 1 et 3", 10_000);
                                    } else {
                                        if (CommandGamem.jeu[number - 1][number2 - 1].equalsIgnoreCase("   ")) {
                                            CommandGamem.tour++;
                                            CommandGamem.jeu[number - 1][number2 - 1] = "X";
                                            event.getChannel().sendMessage("-          1    2    3");
                                            event.getChannel().sendMessage("-          |     |     |");
                                            event.getChannel().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                            event.getChannel().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                            event.getChannel().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                            event.getChannel().sendMessage("Vous venez de jouer, c'est a votre adversaire");
                                            event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("-          1    2    3");
                                            event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("-          |     |     |");
                                            event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                            event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                            event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                            event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("votre adversaire viens de jouer c'est a vous :");

                                        } else {
                                            MessageUtils.sendAndDelete(event.getChannel(), "un pion est déja posé ici", 10_000);
                                        }
                                    }
                                } catch (NumberFormatException e) {
                                    MessageUtils.sendAndDelete(event.getChannel(), "veuillez choisir des nombres corrects compris entre 1 et 3", 10_000);
                                }

                            }
                        } else {
                            if (CommandGamem.tour == 3) {
                                MessageUtils.sendAndDelete(event.getChannel(), "Votre adversaire n'a pas encore jouer", 10_000);
                            }
                            if (CommandGamem.tour == 4) {
                                if (args.length < 2) {
                                    MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                                } else if (args.length > 2) {
                                    MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                                } else if (args.length == 2) {
                                    try {
                                        int number = Integer.parseInt(args[0]);
                                        int number2 = Integer.parseInt(args[1]);
                                        if (number < 1 || number > 3 || number2 < 1 || number2 > 3) {
                                            MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir des nombres compris entre 1 et 3", 10_000);
                                        } else {
                                            if (CommandGamem.jeu[number - 1][number2 - 1].equalsIgnoreCase("   ")) {
                                                CommandGamem.tour++;
                                                CommandGamem.jeu[number - 1][number2 - 1] = "X";
                                                CommandGamem.getWinner();
                                                if (CommandGamem.chan != 0) {
                                                    event.getChannel().sendMessage("-          1    2    3");
                                                    event.getChannel().sendMessage("-          |     |     |");
                                                    event.getChannel().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                                    event.getChannel().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                                    event.getChannel().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                                    event.getChannel().sendMessage("Vous venez de jouer, c'est a votre adversaire");
                                                    event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("-          1    2    3");
                                                    event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("-          |     |     |");
                                                    event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                                    event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                                    event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                                    event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("votre adversaire viens de jouer c'est a vous :");
                                                }

                                            } else {
                                                MessageUtils.sendAndDelete(event.getChannel(), "un pion est déja posé ici", 10_000);
                                            }
                                        }
                                    } catch (NumberFormatException e) {
                                        MessageUtils.sendAndDelete(event.getChannel(), "veuillez choisir des nombres corrects compris entre 1 et 3", 10_000);
                                    }

                                }
                            } else {
                                if (CommandGamem.tour == 5) {
                                    MessageUtils.sendAndDelete(event.getChannel(), "Votre adversaire n'a pas encore jouer", 10_000);
                                }
                                if (CommandGamem.tour == 6) {
                                    if (args.length < 2) {
                                        MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                                    } else if (args.length > 2) {
                                        MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                                    } else if (args.length == 2) {
                                        try {
                                            int number = Integer.parseInt(args[0]);
                                            int number2 = Integer.parseInt(args[1]);
                                            if (number < 1 || number > 3 || number2 < 1 || number2 > 3) {
                                                MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir des nombres compris entre 1 et 3", 10_000);
                                            } else {
                                                if (CommandGamem.jeu[number - 1][number2 - 1].equalsIgnoreCase("   ")) {
                                                    CommandGamem.tour++;
                                                    CommandGamem.jeu[number - 1][number2 - 1] = "X";
                                                    CommandGamem.getWinner();
                                                    if (CommandGamem.chan != 0) {
                                                        event.getChannel().sendMessage("-          1    2    3");
                                                        event.getChannel().sendMessage("-          |     |     |");
                                                        event.getChannel().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                                        event.getChannel().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                                        event.getChannel().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                                        event.getChannel().sendMessage("Vous venez de jouer, c'est a votre adversaire");
                                                        event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("-          1    2    3");
                                                        event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("-          |     |     |");
                                                        event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                                        event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                                        event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                                        event.getServer().get().getTextChannelById(CommandGamem.chan).get().sendMessage("votre adversaire viens de jouer c'est a vous :");
                                                    }

                                                } else {
                                                    MessageUtils.sendAndDelete(event.getChannel(), "un pion est déja posé ici", 10_000);
                                                }
                                            }
                                        } catch (NumberFormatException e) {
                                            MessageUtils.sendAndDelete(event.getChannel(), "veuillez choisir des nombres corrects compris entre 1 et 3", 10_000);
                                        }
                                    }
                                } else {
                                    if (CommandGamem.tour == 7) {
                                        MessageUtils.sendAndDelete(event.getChannel(), "Votre adversaire n'a pas encore jouer", 10_000);
                                    }
                                    if (CommandGamem.tour == 8) {
                                        if (args.length < 2) {
                                            MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                                        } else if (args.length > 2) {
                                            MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                                        } else if (args.length == 2) {
                                            try {
                                                int number = Integer.parseInt(args[0]);
                                                int number2 = Integer.parseInt(args[1]);
                                                if (number < 1 || number > 3 || number2 < 1 || number2 > 3) {
                                                    MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir des nombres compris entre 1 et 3", 10_000);
                                                } else {
                                                    if (CommandGamem.jeu[number - 1][number2 - 1].equalsIgnoreCase("   ")) {
                                                        CommandGamem.tour++;
                                                        CommandGamem.jeu[number - 1][number2 - 1] = "X";
                                                        CommandGamem.getWinner();
                                                        if (CommandGamem.chan != 0) {
                                                            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + " et " + CommandGamem.player2 + " sont à égalité résultats :");
                                                            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage(CommandGamem.player1 + ": X   " + CommandGamem.player2 + ": O");
                                                            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          1    2    3");
                                                            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("-          |     |     |");
                                                            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                                            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                                            Main.api.getServerById("793504580217339974").get().getTextChannelById("820627712707395614").get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                                            CommandGamem.clean();
                                                        }
                                                    } else {
                                                        MessageUtils.sendAndDelete(event.getChannel(), "un pion est déja posé ici", 10_000);
                                                    }
                                                }
                                            } catch (NumberFormatException e) {
                                                MessageUtils.sendAndDelete(event.getChannel(), "veuillez choisir des nombres corrects compris entre 1 et 3", 10_000);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }

                if (event.getChannel().getId() == CommandGamem.chan){
                    if (CommandGamem.tour == 0) {
                        MessageUtils.sendAndDelete(event.getChannel(), "Votre adversaire n'a pas encore jouer", 10_000);
                    }
                    if (CommandGamem.tour == 1) {
                        if (args.length < 2) {
                            MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                        } else if (args.length > 2) {
                            MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                        } else if (args.length == 2) {
                            try {
                                int number = Integer.parseInt(args[0]);
                                int number2 = Integer.parseInt(args[1]);
                                if (number < 1 || number > 3 || number2 < 1 || number2 > 3) {
                                    MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir des nombres compris entre 1 et 3", 10_000);
                                } else {
                                    if (CommandGamem.jeu[number - 1][number2 - 1].equalsIgnoreCase("   ")){
                                        CommandGamem.tour++;
                                        CommandGamem.jeu[number - 1][number2 - 1] = "O";
                                        event.getChannel().sendMessage("-          1    2    3");
                                        event.getChannel().sendMessage("-          |     |     |");
                                        event.getChannel().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                        event.getChannel().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                        event.getChannel().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                        event.getChannel().sendMessage("Vous venez de jouer, c'est a votre adversaire");
                                        event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("-          1    2    3");
                                        event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("-          |     |     |");
                                        event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                        event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                        event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                        event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("votre adversaire viens de jouer c'est a vous :");

                                    } else {
                                        MessageUtils.sendAndDelete(event.getChannel(), "un pion est déja posé ici", 10_000);
                                    }
                                }
                            } catch (NumberFormatException e) {
                                MessageUtils.sendAndDelete(event.getChannel(), "veuillez choisir des nombres corrects compris entre 1 et 3", 10_000);
                            }

                        }
                    } else {
                        if (CommandGamem.tour == 2) {
                            MessageUtils.sendAndDelete(event.getChannel(), "Votre adversaire n'a pas encore jouer", 10_000);
                        }
                        if (CommandGamem.tour == 3) {
                            if (args.length < 2) {
                                MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                            } else if (args.length > 2) {
                                MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                            } else if (args.length == 2) {
                                try {
                                    int number = Integer.parseInt(args[0]);
                                    int number2 = Integer.parseInt(args[1]);
                                    if (number < 1 || number > 3 || number2 < 1 || number2 > 3) {
                                        MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir des nombres compris entre 1 et 3", 10_000);
                                    } else {
                                        if (CommandGamem.jeu[number - 1][number2 - 1].equalsIgnoreCase("   ")){
                                            CommandGamem.tour++;
                                            CommandGamem.jeu[number - 1][number2 - 1] = "O";
                                            event.getChannel().sendMessage("-          1    2    3");
                                            event.getChannel().sendMessage("-          |     |     |");
                                            event.getChannel().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                            event.getChannel().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                            event.getChannel().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                            event.getChannel().sendMessage("Vous venez de jouer, c'est a votre adversaire");
                                            event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("-          1    2    3");
                                            event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("-          |     |     |");
                                            event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                            event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                            event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                            event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("votre adversaire viens de jouer c'est a vous :");

                                        } else {
                                            MessageUtils.sendAndDelete(event.getChannel(), "un pion est déja posé ici", 10_000);
                                        }
                                    }
                                } catch (NumberFormatException e) {
                                    MessageUtils.sendAndDelete(event.getChannel(), "veuillez choisir des nombres corrects compris entre 1 et 3", 10_000);
                                }

                            }
                        } else {
                            if (CommandGamem.tour == 4) {
                                MessageUtils.sendAndDelete(event.getChannel(), "Votre adversaire n'a pas encore jouer", 10_000);
                            }
                            if (CommandGamem.tour == 5) {
                                if (args.length < 2) {
                                    MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                                } else if (args.length > 2) {
                                    MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                                } else if (args.length == 2) {
                                    try {
                                        int number = Integer.parseInt(args[0]);
                                        int number2 = Integer.parseInt(args[1]);
                                        if (number < 1 || number > 3 || number2 < 1 || number2 > 3) {
                                            MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir des nombres compris entre 1 et 3", 10_000);
                                        } else {
                                            if (CommandGamem.jeu[number - 1][number2 - 1].equalsIgnoreCase("   ")) {
                                                CommandGamem.tour++;
                                                CommandGamem.jeu[number - 1][number2 - 1] = "O";
                                                CommandGamem.getWinner();
                                                if (CommandGamem.chan != 0) {
                                                    event.getChannel().sendMessage("-          1    2    3");
                                                    event.getChannel().sendMessage("-          |     |     |");
                                                    event.getChannel().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                                    event.getChannel().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                                    event.getChannel().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                                    event.getChannel().sendMessage("Vous venez de jouer, c'est a votre adversaire");
                                                    event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("-          1    2    3");
                                                    event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("-          |     |     |");
                                                    event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                                    event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                                    event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                                    event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("votre adversaire viens de jouer c'est a vous :");
                                                }

                                            } else {
                                                MessageUtils.sendAndDelete(event.getChannel(), "un pion est déja posé ici", 10_000);
                                            }
                                        }
                                    } catch (NumberFormatException e) {
                                        MessageUtils.sendAndDelete(event.getChannel(), "veuillez choisir des nombres corrects compris entre 1 et 3", 10_000);
                                    }

                                }
                            } else {
                                if (CommandGamem.tour == 6) {
                                    MessageUtils.sendAndDelete(event.getChannel(), "Votre adversaire n'a pas encore jouer", 10_000);
                                }
                                if (CommandGamem.tour == 7) {
                                    if (args.length < 2) {
                                        MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                                    } else if (args.length > 2) {
                                        MessageUtils.sendAndDelete(event.getChannel(), "Veuillez sélectionner la case avec la syntaxe suivante : -game    numéro_vertical_de_la_case      numéro_horizontal_de_la_case", 10_000);
                                    } else if (args.length == 2) {
                                        try {
                                            int number = Integer.parseInt(args[0]);
                                            int number2 = Integer.parseInt(args[1]);
                                            if (number < 1 || number > 3 || number2 < 1 || number2 > 3) {
                                                MessageUtils.sendAndDelete(event.getChannel(), "merci de choisir des nombres compris entre 1 et 3", 10_000);
                                            } else {
                                                if (CommandGamem.jeu[number - 1][number2 - 1].equalsIgnoreCase("   ")) {
                                                    CommandGamem.tour++;
                                                    CommandGamem.jeu[number - 1][number2 - 1] = "O";
                                                    CommandGamem.getWinner();
                                                    if (CommandGamem.chan != 0) {
                                                        event.getChannel().sendMessage("-          1    2    3");
                                                        event.getChannel().sendMessage("-          |     |     |");
                                                        event.getChannel().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                                        event.getChannel().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                                        event.getChannel().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                                        event.getChannel().sendMessage("Vous venez de jouer, c'est a votre adversaire");
                                                        event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("-          1    2    3");
                                                        event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("-          |     |     |");
                                                        event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("1  -> [" + CommandGamem.jeu[0][0] + "][" + CommandGamem.jeu[0][1] + "][" + CommandGamem.jeu[0][2] + "]");
                                                        event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("2 -> [" + CommandGamem.jeu[1][0] + "][" + CommandGamem.jeu[1][1] + "][" + CommandGamem.jeu[1][2] + "]");
                                                        event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("3 -> [" + CommandGamem.jeu[2][0] + "][" + CommandGamem.jeu[2][1] + "][" + CommandGamem.jeu[2][2] + "]");
                                                        event.getServer().get().getTextChannelById(CommandGamem.cha).get().sendMessage("votre adversaire viens de jouer c'est a vous :");
                                                    }

                                                } else {
                                                    MessageUtils.sendAndDelete(event.getChannel(), "un pion est déja posé ici", 10_000);
                                                }
                                            }
                                        } catch (NumberFormatException e) {
                                            MessageUtils.sendAndDelete(event.getChannel(), "veuillez choisir des nombres corrects compris entre 1 et 3", 10_000);
                                        }

                                    }
                                } else {
                                    if (CommandGamem.tour == 8) {
                                        MessageUtils.sendAndDelete(event.getChannel(), "Votre adversaire n'a pas encore jouer", 10_000);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                MessageUtils.sendAndDelete(event.getChannel(), "En attente de joueur...", 10_000);
            }

        }

    }
}
