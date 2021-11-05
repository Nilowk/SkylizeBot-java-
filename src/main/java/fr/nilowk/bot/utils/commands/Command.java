package fr.nilowk.bot.utils.commands;

public class Command {

    private String id, descrition;
    private String[] aliases;
    private CommandExecutor executor;

    public Command(String id, String descrition, CommandExecutor executor, String... aliases) {
        this.id = id;
        this.descrition = descrition;
        this.aliases = aliases;
        this.executor = executor;
    }

    public String getId() {
        return id;
    }

    public String getDescrition() {
        return descrition;
    }

    public String[] getAliases() {
        return aliases;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

}
