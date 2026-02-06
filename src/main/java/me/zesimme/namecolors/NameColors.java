package me.zesimme.namecolors;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.ChatColor;

import java.util.*;

public final class NameColors extends JavaPlugin {

    @Override
    public void onEnable() {
        constructTeamColorList();
        Player zeSimme = Bukkit.getPlayer("ZeSimme");
        teamColors.get(ChatColor.GOLD).addPlayer(zeSimme);
        teamColors.get(ChatColor.GOLD).addEntry(zeSimme.getDisplayName());
        zeSimme.sendMessage("added you to team orange");
    }



    private Map<ChatColor, Team> teamColors;
    private final List<ChatColor> colors = new ArrayList<>(Arrays.asList(ChatColor.RED, ChatColor.AQUA, ChatColor.DARK_AQUA, ChatColor.BLACK, ChatColor.BLUE, ChatColor.DARK_AQUA, ChatColor.DARK_BLUE, ChatColor.GOLD, ChatColor.DARK_GRAY, ChatColor.DARK_GREEN, ChatColor.DARK_PURPLE, ChatColor.LIGHT_PURPLE, ChatColor.GREEN, ChatColor.DARK_RED, ChatColor.GRAY, ChatColor.YELLOW, ChatColor.WHITE));
    private void constructTeamColorList() {
        teamColors = new HashMap<>();

        for (ChatColor color : colors) {
            teamColors.put(color, new Team() {

                final Set<OfflinePlayer> teamMembers = new HashSet<>();
                final Set<String> teamEntries = new HashSet<>();

                @Override
                public String getName() throws IllegalStateException {
                    return color.name();
                }

                @Override
                public String getDisplayName() throws IllegalStateException {
                    return color.name() + " team";
                }

                @Override
                public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {

                }

                @Override
                public String getPrefix() throws IllegalStateException {
                    return ChatColor.GOLD + "Orange ";
                }

                @Override
                public void setPrefix(String prefix) throws IllegalStateException, IllegalArgumentException {

                }

                @Override
                public String getSuffix() throws IllegalStateException {
                    return null;
                }

                @Override
                public void setSuffix(String suffix) throws IllegalStateException, IllegalArgumentException {

                }

                @Override
                public ChatColor getColor() throws IllegalStateException {
                    return color;
                }

                @Override
                public void setColor(org.bukkit.ChatColor color) {

                }

                @Override
                public boolean allowFriendlyFire() throws IllegalStateException {
                    return false;
                }

                @Override
                public void setAllowFriendlyFire(boolean enabled) throws IllegalStateException {

                }

                @Override
                public boolean canSeeFriendlyInvisibles() throws IllegalStateException {
                    return false;
                }

                @Override
                public void setCanSeeFriendlyInvisibles(boolean enabled) throws IllegalStateException {

                }

                @Override
                public NameTagVisibility getNameTagVisibility() throws IllegalArgumentException {
                    return null;
                }

                @Override
                public void setNameTagVisibility(NameTagVisibility visibility) throws IllegalArgumentException {

                }

                @Override
                public Set<OfflinePlayer> getPlayers() throws IllegalStateException {
                    return teamMembers;
                }

                @Override
                public Set<String> getEntries() throws IllegalStateException {
                    return teamEntries;
                }

                @Override
                public int getSize() throws IllegalStateException {
                    return 0;
                }

                @Override
                public Scoreboard getScoreboard() {
                    return null;
                }

                @Override
                public void addPlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
                    teamMembers.add(player);
                }

                @Override
                public void addEntry(String entry) throws IllegalStateException, IllegalArgumentException {
                    teamEntries.add(entry);
                }

                @Override
                public boolean removePlayer(OfflinePlayer player) throws IllegalStateException, IllegalArgumentException {
                    return teamMembers.remove(player);
                }

                @Override
                public boolean removeEntry(String entry) throws IllegalStateException, IllegalArgumentException {
                    return teamEntries.remove(entry);
                }

                @Override
                public void unregister() throws IllegalStateException {

                }

                @Override
                public boolean hasPlayer(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
                    return teamMembers.contains(player);
                }

                @Override
                public boolean hasEntry(String entry) throws IllegalArgumentException, IllegalStateException {
                    return teamEntries.contains(entry);
                }

                @Override
                public OptionStatus getOption(Option option) throws IllegalStateException {
                    return null;
                }

                @Override
                public void setOption(Option option, OptionStatus status) throws IllegalStateException {

                }
            });
        }
    }
}
