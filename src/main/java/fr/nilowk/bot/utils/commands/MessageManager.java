package fr.nilowk.bot.utils.commands;

import fr.nilowk.bot.Main;
import fr.nilowk.bot.commands.*;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Arrays;

public class MessageManager {

    private static CommandRegistry registry = new CommandRegistry();

    static {
        registry.addCommand(new Command(
                "clear",
                "cette commande permet de clear un certain nombre de message",
                new CommandClear(),
                "clear", "cl"
        ));
        registry.addCommand(new Command(
                "help",
                "cette commande permet de voir la liste des commandes",
                new CommandHelp(),
                "help", "hl"
        ));
        registry.addCommand(new Command(
                "rstats",
                "cette commande permet de regénérer les stats",
                new CommandRstats(),
                "rstats", "rstat"
        ));
        registry.addCommand(new Command(
                "cstats",
                "cette commande permet de clear les stats",
                new CommandCstats(),
                "cstats", "cstat"
        ));
        registry.addCommand(new Command(
                "rules",
                "cette commande permet d'afficher les règles si nécéssaire",
                new CommandRules(),
                "rules", "rule"
        ));
        registry.addCommand(new Command(
                "new",
                "cette commande permet de parler avec les modérateurs/admins (commande dans les mp du bot)",
                new CommandNew(),
                "new", "n"
        ));
        registry.addCommand(new Command(
                "close",
                "cette commande permet de fermer un ticket",
                new CommandClose(),
                "close", "c"
        ));
        registry.addCommand(new Command(
                "ban",
                "cette commande permet de ban",
                new CommandBan(),
                "ban", "b"
        ));
        registry.addCommand(new Command(
                "annonce",
                "cette commande permet de faire une annonce",
                new CommandAnnonce(),
                "annonce", "a"
        ));
        registry.addCommand(new Command(
                "cconfig",
                "",
                new CommandCconfig(),
                "cconfig", "cc"
        ));
        registry.addCommand(new Command(
                "kick",
                "cette commande permet de kick un membre ",
                new CommandKick(),
                "kick", "k"
        ));
        registry.addCommand(new Command(
                "gameppc",
                "permet de faire un pierre feuille papier ciseau entre ami",
                new CommandGameppc(),
                "gameppc", "ppc"
        ));
        registry.addCommand(new Command(
                "pierre",
                "la pierre",
                new CommandPierre(),
                "pierre", "rock"
        ));
        registry.addCommand(new Command(
                "papier",
                "le papier",
                new CommandPapier(),
                "papier", "paper"
        ));
        registry.addCommand(new Command(
                "ciseaux",
                "les ciseaux",
                new CommandCiseaux(),
                "ciseaux", "ciseaux"
        ));
        registry.addCommand(new Command(
                "ok",
                "pour validée le pierre feuille ciseaux",
                new CommandOk(),
                "ok", "ya"
        ));
        registry.addCommand(new Command(
                "gameclean",
                "pour clear le pierre feuille ciseaux",
                new CommandGameClean(),
                "gameclean", "gamec"
        ));
        registry.addCommand(new Command(
                "gamem",
                "permet de faire un morpion",
                new CommandGamem(),
                "gamem", "gamemorpion"
        ));
        registry.addCommand(new Command(
                "game",
                "permet de jouer au morpion",
                new CommandeGame(),
                "game", "g"
        ));
        registry.addCommand(new Command(
                "gamep4",
                "permet de jouer au puissance 4",
                new CommandGamep4(),
                "gamep4", "game4"
        ));
        registry.addCommand(new Command(
                "gamep",
                "",
                new CommandGamep(),
                "gamep", "gp"
        ));
    }

    private static final String PREFIX = Main.getConfigManager().getToml().getString("bot.prefix");

    public static void create(MessageCreateEvent event) {

        if (event.getMessageContent().startsWith(PREFIX)) {
            String[] args = event.getMessageContent().split(" ");
            String commandName = args[0].substring(PREFIX.length());
            args = args.length == 1 ? new String[0] : Arrays.copyOfRange(args, 1, args.length);

            String[] finalArgs = args;
            registry.getByAlias(commandName).ifPresent((cmd -> {
                cmd.getExecutor().run(event, cmd, finalArgs);
            }));
        }

    }

}
