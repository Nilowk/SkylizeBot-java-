package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandKick implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();

        if (event.getMessageAuthor().canKickUsersFromServer()) {

            String[] arg = event.getMessageContent().split("ù");

            User kickmember = event.getMessage().getMentionedUsers().get(0);

            if (args.length < 1) { ;
                MessageUtils.sendAndDelete(event.getChannel(), "merci de définir une personne à ban", 10_000);
            } else if(arg.length < 2){
                kickmember.sendMessage("Vous avez été kick de Skylize RP, raison : non spécifié");
                event.getServer().get().kickUser(kickmember);
                MessageUtils.sendAndDelete(event.getChannel(), "l'utilisateur " + kickmember.getMentionTag() + " à été kick |", 10_000);
            } else {
                kickmember.sendMessage("Vous avez été kick de Skylize RP, raison :" + arg[1]);
                event.getServer().get().kickUser(kickmember, arg[1]);
                MessageUtils.sendAndDelete(event.getChannel(), "l'utilisateur " + kickmember.getMentionTag() + " à été kick |" + "| raison : " + arg[1], 10_000);
            }
        }
    }
}
