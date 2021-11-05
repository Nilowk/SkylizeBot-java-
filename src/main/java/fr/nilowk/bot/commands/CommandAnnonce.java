package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandAnnonce implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {

        event.getMessage().delete();

        if (event.getMessageAuthor().canManageServer()) {

            if (args.length < 1) {
                MessageUtils.sendAndDelete(event.getChannel(), "Merci de définir la commande avec la syntaxe suivante -> -annonce ù type ù msg ", 10_000);
            }
            if (args.length < 2) {
                MessageUtils.sendAndDelete(event.getChannel(), "Merci de définir la commande avec la syntaxe suivante -> -annonce ù type ù msg ", 10_000);
            }
            if (args.length < 3) {
                MessageUtils.sendAndDelete(event.getChannel(), "Merci de définir la commande avec la syntaxe suivante -> -annonce ù type ù msg ", 10_000);
            } else {

                String[] arg = event.getMessageContent().split("ù");

                EmbedBuilder embed = new EmbedBuilder()
                        .setTitle("**" + arg[1] + "**")
                        .setAuthor("Skylize RP", "", "https://i.postimg.cc/g2QYSZr3/logo.png")
                        .setDescription(arg[2])
                        .setFooter("By Nilowk")
                        .setTimestampToNow();
                event.getChannel().sendMessage("@everyone", embed);




            }


        }

    }
}
