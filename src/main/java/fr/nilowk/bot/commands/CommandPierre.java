package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandPierre implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();
        if (CommandGameppc.nump >= 1) {

            if (event.getChannel().getId() == CommandGameppc.cha) {
                if (CommandGameppc.pr1 == 0) {
                    CommandGameppc.p1 = "pierre";
                    event.getChannel().sendMessage("vous venez de sélectionner la pierre, pour confirmer votre choix merci de taper -ok");
                } else {
                    MessageUtils.sendAndDelete(event.getChannel(), "Vous avez déjà validé votre choix", 10_000);
                }
            }

            if (CommandGameppc.chan != 0) {
                if (event.getChannel().getId() == CommandGameppc.chan) {
                    if (CommandGameppc.pr2 == 0) {
                        CommandGameppc.p2 = "pierre";
                        event.getChannel().sendMessage("vous venez de sélectionner la pierre, pour confirmer votre choix merci de taper -ok");
                    } else {
                        MessageUtils.sendAndDelete(event.getChannel(), "Vous avez déjà validé votre choix", 10_000);
                    }
                }
            }

        }
    }
}

