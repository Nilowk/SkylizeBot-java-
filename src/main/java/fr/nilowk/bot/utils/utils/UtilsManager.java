package fr.nilowk.bot.utils.utils;

import org.javacord.api.entity.channel.ServerVoiceChannelBuilder;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelMemberJoinEvent;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelMemberLeaveEvent;

public class UtilsManager {

    public static void createChannel(ServerVoiceChannelMemberJoinEvent event) {

        if (event.getChannel() == event.getServer().getVoiceChannelById("817464610193539092").get()) {

            new ServerVoiceChannelBuilder(event.getServer())
                    .setName("🔓 channel de " + event.getUser().getName() + " 🔓")
                    .setCategory(event.getServer().getChannelCategoryById("794598385575264286").get())
                    .create().thenAcceptAsync(serverVoiceChannel -> {
                        event.getUser().move(serverVoiceChannel);
                    });

        }

    }

    public static void deleteChannel(ServerVoiceChannelMemberLeaveEvent event) {

        if (event.getChannel() != event.getServer().getVoiceChannelById("817464610193539092").get()) {
            if (event.getChannel() != event.getServer().getVoiceChannelById("794595527533527040").get()) {
                if (event.getChannel() != event.getServer().getVoiceChannelById("794596405447491594").get()) {
                    if (event.getChannel() != event.getServer().getVoiceChannelById("794596963416670219").get()) {
                        if (event.getChannel() != event.getServer().getVoiceChannelById("794599273252913154").get()) {
                            if (event.getChannel() != event.getServer().getVoiceChannelById("794599273252913154").get()) {
                                if (event.getChannel() != event.getServer().getVoiceChannelById("794668037026480168").get()) {
                                    if (event.getChannel() != event.getServer().getVoiceChannelById("817466284614615123").get()) {
                                        if (event.getChannel() != event.getServer().getVoiceChannelById("800100859052032041").get()){
                                            if (event.getChannel() != event.getServer().getVoiceChannelById("800100912583802900").get()) {
                                                if (event.getChannel().getConnectedUsers().size() < 1) {

                                                    event.getChannel().delete();

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

    }

}
