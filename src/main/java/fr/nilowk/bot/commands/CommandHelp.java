package fr.nilowk.bot.commands;

import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandHelp implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();
        EmbedBuilder embed = new EmbedBuilder()
                .setAuthor("Skylize RP", "", "https://i.postimg.cc/g2QYSZr3/logo.png")
                .setTitle("**liste des commandes :**")
                .addField("**-help/-hl**", command.getDescrition())
                .addField("**-rules/-rule**", "permet d'afficher le règlement si nécéssaire")
                .addField("**-new/-n**", "permet de crée un ticket")
                .addField("***-clear/-cl***", "cette commande permet de supprimer un certain nombre de message (commande modo)")
                .addField("***-close/-c***", "cette commande permet de delete n'importe quel channel 🛑 (commande modo)")
                .addField("***-ban/-b***", "cette commande permet de ban un membre (commande modo)")
                .addField("***-rstats/-rstat***", "cette commande permet de regénéré les stats (commande admin)")
                .addField("***-cstats/-cstat***", "cette commande permet de clear les stats (commande admin")
                .addField("***-annonce ù type ù msg/-a ù type ù msg***", "cette commande permet de faire une annonce stylisé (commande admin)")
                .setFooter("By Nilowk")
                .setTimestampToNow();
        event.getChannel().sendMessage(embed);
    }
}
