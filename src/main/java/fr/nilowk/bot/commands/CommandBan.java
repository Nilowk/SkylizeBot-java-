package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandBan implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();

        if (event.getMessageAuthor().canBanUsersFromServer()) {

            String[] arg = event.getMessageContent().split("ù");

            User banmember = event.getMessage().getMentionedUsers().get(0);

            if (args.length < 1) { ;
                MessageUtils.sendAndDelete(event.getChannel(), "merci de définir une personne à ban", 10_000);
            } else if(arg.length < 2){
                banmember.sendMessage("Vous avez été bannis de Skylize RP, raison : non spécifié");
                event.getServer().get().banUser(banmember);
                MessageUtils.sendAndDelete(event.getChannel(), "l'utilisateur " + banmember.getMentionTag() + " à été banni |", 10_000);
            } else {
                banmember.sendMessage("Vous avez été bannis de Skylize RP, raison :" + arg[1]);
                event.getServer().get().banUser(banmember, 0, arg[1]);
                MessageUtils.sendAndDelete(event.getChannel(), "l'utilisateur " + banmember.getMentionTag() + " à été banni |" + "| raison : " + arg[1], 10_000);
            }
        }
    }
}
