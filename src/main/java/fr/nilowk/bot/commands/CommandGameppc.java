package fr.nilowk.bot.commands;

import fr.nilowk.bot.Main;
import fr.nilowk.bot.utils.MessageUtils;
import fr.nilowk.bot.utils.commands.Command;
import fr.nilowk.bot.utils.commands.CommandExecutor;
import org.javacord.api.entity.channel.ServerTextChannelBuilder;
import org.javacord.api.entity.permission.PermissionType;
import org.javacord.api.entity.permission.PermissionsBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

public class CommandGameppc implements CommandExecutor {

    public static long cha = 0;
    public static long chan = 0;
    public static int nump = 0;
    public static String player1 = "";
    public static int pr1 = 0;
    public static String p1 = "";
    public static String player2 = "";
    public static int pr2 = 0;
    public static String p2 = "";
    public static int ready = 0;

    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        event.getMessage().delete();
        nump++;

        if (nump < 2) {

            new ServerTextChannelBuilder(event.getServer().get())
                    .setName("🥊 " + event.getMessageAuthor().getName() + " / ppc 🥊")
                    .setCategory(event.getServer().get().getChannelCategoryById("820292075048009778").get())
                    .addPermissionOverwrite(event.getMessageAuthor().asUser().get(), new PermissionsBuilder().setAllowed(PermissionType.READ_MESSAGES).build())
                    .addPermissionOverwrite(event.getServer().get().getEveryoneRole(), new PermissionsBuilder().setDenied(PermissionType.READ_MESSAGES).build())
                    .create().thenAcceptAsync(channel -> {
                        MessageUtils.sendAndDelete(event.getChannel(), "le jeux se passe dans ce channel -> ", 10_000);
                        event.getChannel().sendMessage(channel.getMentionTag()).thenAcceptAsync(message -> {
                            try {
                                Thread.sleep(10_000);
                                message.delete();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                        cha = channel.getId();
                        channel.sendMessage("Pierre, Papier, Ciseau :");
                        channel.sendMessage("Pour se jeu les règle sont simple choisissez entre la pierre, le papier et les ciseaux en utilisant les commandes suivantes :");
                        channel.sendMessage("-pierre, -papier ou -ciseaux");
            });
            player1 = event.getMessageAuthor().asUser().get().getMentionTag();

        }
        if (nump == 2) {
            new ServerTextChannelBuilder(event.getServer().get())
                    .setName("🥊 " + event.getMessageAuthor().getName() + " / ppc 🥊")
                    .setCategory(event.getServer().get().getChannelCategoryById("820292075048009778").get())
                    .addPermissionOverwrite(event.getMessageAuthor().asUser().get(), new PermissionsBuilder().setAllowed(PermissionType.READ_MESSAGES).build())
                    .addPermissionOverwrite(event.getServer().get().getEveryoneRole(), new PermissionsBuilder().setDenied(PermissionType.READ_MESSAGES).build())
                    .create().thenAcceptAsync(channel -> {
                MessageUtils.sendAndDelete(event.getChannel(), "le jeux se passe dans ce channel -> ", 10_000);
                event.getChannel().sendMessage(channel.getMentionTag()).thenAcceptAsync(message -> {
                    try {
                        Thread.sleep(10_000);
                        message.delete();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                chan = channel.getId();
                channel.sendMessage("Pierre, Papier, Ciseau :");
                channel.sendMessage("Pour se jeu les règle sont simple choisissez entre la pierre, le papier et les ciseaux en utilisant les commandes suivantes :");
                channel.sendMessage("-pierre, -papier ou -ciseaux");
            });
            player2 = event.getMessageAuthor().asUser().get().getMentionTag();
        }

        if (nump >= 3) {
            MessageUtils.sendAndDelete(event.getChannel(), "Une partie de pierre feuille papier ciseaux est déjà en cour", 10_000);
        }

    }

    public static void getWinner() {

        if (p1.equalsIgnoreCase("pierre") && p2.equalsIgnoreCase("pierre")) {

            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage("égalité entre " + player1 + " et " + player2 + ", les deux ont choisi la pierre");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage("Pour recommencer une partie merci de taper -gameppc ici ->");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(Main.api.getServerById("793504580217339974").get().getTextChannelById("814571822736867368").get().getMentionTag());


        }

        if (p1.equalsIgnoreCase("papier") && p2.equalsIgnoreCase("papier")) {

            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage("égalité entre " + player1 + " et " + player2 + ", les deux ont choisi le papier");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage("Pour recommencer une partie merci de taper -gameppc ici ->");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(Main.api.getServerById("793504580217339974").get().getTextChannelById("814571822736867368").get().getMentionTag());

        }

        if (p1.equalsIgnoreCase("ciseaux") && p2.equalsIgnoreCase("ciseaux")) {

            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage("égalité entre " + player1 + " et " + player2 + ", les deux ont choisi les ciseaux");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage("Pour recommencer une partie merci de taper -gameppc ici ->");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(Main.api.getServerById("793504580217339974").get().getTextChannelById("814571822736867368").get().getMentionTag());

        }

        if (p1.equalsIgnoreCase("pierre") && p2.equalsIgnoreCase("papier")) {

            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(player2 + " a gagné car il a choisi le papier alors que " + player1 + " a choisi la pierre");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage("Pour recommencer une partie merci de taper -gameppc ici ->");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(Main.api.getServerById("793504580217339974").get().getTextChannelById("814571822736867368").get().getMentionTag());

        }

        if (p1.equalsIgnoreCase("papier") && p2.equalsIgnoreCase("pierre")) {

            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(player1 + " a gagné car il a choisi le papier alors que " + player2 + " a choisi la pierre");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage("Pour recommencer une partie merci de taper -gameppc ici ->");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(Main.api.getServerById("793504580217339974").get().getTextChannelById("814571822736867368").get().getMentionTag());

        }

        if (p1.equalsIgnoreCase("pierre") && p2.equalsIgnoreCase("ciseaux")) {

            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(player1 + " a gagné car il a choisi la pierre alors que " + player2 + " a choisi les ciseaux");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage("Pour recommencer une partie merci de taper -gameppc ici ->");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(Main.api.getServerById("793504580217339974").get().getTextChannelById("814571822736867368").get().getMentionTag());

        }

        if (p1.equalsIgnoreCase("ciseaux") && p2.equalsIgnoreCase("pierre")) {

            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(player2 + " a gagné car il a choisi la pierre alors que " + player1 + " a choisi les ciseaux");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage("Pour recommencer une partie merci de taper -gameppc ici ->");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(Main.api.getServerById("793504580217339974").get().getTextChannelById("814571822736867368").get().getMentionTag());

        }

        if (p1.equalsIgnoreCase("papier") && p2.equalsIgnoreCase("ciseaux")) {

            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(player2 + " a gagné car il a choisi les ciseaux alors que " + player1 + " a choisi le papier");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage("Pour recommencer une partie merci de taper -gameppc ici ->");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(Main.api.getServerById("793504580217339974").get().getTextChannelById("814571822736867368").get().getMentionTag());

        }

        if (p1.equalsIgnoreCase("ciseaux") && p2.equalsIgnoreCase("papier")) {

            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(player1 + " a gagné car il a choisi les ciseaux alors que " + player2 + " a choisi le papier");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage("Pour recommencer une partie merci de taper -gameppc ici ->");
            Main.api.getServerById("793504580217339974").get().getTextChannelById("820321511386251304").get().sendMessage(Main.api.getServerById("793504580217339974").get().getTextChannelById("814571822736867368").get().getMentionTag());

        }

        clean();
    }

    public static void clean() {

        Main.api.getServerById("793504580217339974").get().getTextChannelById(cha).get().delete();
        Main.api.getServerById("793504580217339974").get().getTextChannelById(chan).get().delete();

        cha = 0;
        chan = 0;
        nump = 0;
        player1 = "";
        pr1 = 0;
        String p1 = "";
        String player2 = "";
        pr2 = 0;
        String p2 = "";
        ready = 0;

    }

}
