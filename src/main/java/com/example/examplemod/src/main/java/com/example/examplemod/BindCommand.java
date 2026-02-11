package com.example.examplemod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;

public class BindCommand extends CommandBase {
    public static int bindKey = 0;

    @Override
    public String getCommandName() {
        return "bind";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/bind <key> | /bind none";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length != 1) {
            sender.addChatMessage(new ChatComponentText("§cUsage: /bind <key> | /bind none"));
            return;
        }

        String input = args[0].toLowerCase();
        if (input.equals("none")) {
            bindKey = 0;
            sender.addChatMessage(new ChatComponentText("§aUnbind success"));
        } else {
            int key = Keyboard.getKeyIndex(input.toUpperCase());
            if (key != 0) {
                bindKey = key;
                sender.addChatMessage(new ChatComponentText("§aBinding success"));
            } else {
                sender.addChatMessage(new ChatComponentText("§cInvalid key"));
            }
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
