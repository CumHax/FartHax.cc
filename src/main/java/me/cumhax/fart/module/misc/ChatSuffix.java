package me.cumhax.fart.module.misc;

import me.cumhax.fart.module.Category;
import me.cumhax.fart.module.Module;
import me.cumhax.fart.util.LoggerUtil;
import java.util.Arrays;
import java.util.Iterator;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatSuffix extends Module {

   public ChatSuffix()
   {
      super("ChatSuffix", "", Category.CLIENT);
   }
   @SubscribeEvent
   public void onChat(ClientChatEvent event) {
      Iterator var2 = Arrays.asList("/", ".", "-", ",", ":", ";", "'", "\"", "+", "\\").iterator();

      String s;
      do {
         if (!var2.hasNext()) {
            event.setMessage(event.getMessage() + " ｜ ꜰᴀʀᴛʜᴀx");
            return;
         }

         s = (String)var2.next();
      } while(!event.getMessage().startsWith(s));
   }
}
