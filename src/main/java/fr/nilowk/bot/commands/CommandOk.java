package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandOk implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {

        event.getMessage().delete();
        if (CommandGameppc.nump >= 1) {

            if (CommandGameppc.p1.equalsIgnoreCase("pierre") || CommandGameppc.p1.equalsIgnoreCase("papier") || CommandGameppc.p1.equalsIgnoreCase("ciseaux"))
                if (event.getChannel().getId() == CommandGameppc.cha) {

                    if (CommandGameppc.pr1 == 0) {

                        CommandGameppc.ready++;

                        CommandGameppc.pr1++;

                        MessageUtils.sendAndDelete(event.getChannel(), "Vous venez de validé votre choix : " + CommandGameppc.p1, 10_000);

                        if (CommandGameppc.ready == 2) {

                            CommandGameppc.getWinner();

                        }

                    }

                }

            if (CommandGameppc.p2.equalsIgnoreCase("pierre") || CommandGameppc.p2.equalsIgnoreCase("papier") || CommandGameppc.p2.equalsIgnoreCase("ciseaux")) {
                if (CommandGameppc.chan != 0) {

                    if (event.getChannel().getId() == CommandGameppc.chan) {

                        if (CommandGameppc.pr2 == 0) {

                            CommandGameppc.ready++;

                            CommandGameppc.pr2++;

                            MessageUtils.sendAndDelete(event.getChannel(), "Vous venez de validé votre choix : " + CommandGameppc.p2, 10_000);

                            if (CommandGameppc.ready == 2) {

                                CommandGameppc.getWinner();

                            }

                        }


                    }

                }
            }

        }

    }

}

