/*   1:    */ package org.linphone.core.tutorials;
/*   2:    */ 
/*   3:    */ import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCall.State;
import org.linphone.core.LinphoneCallStats;
import org.linphone.core.LinphoneChatMessage;
import org.linphone.core.LinphoneChatMessage.StateListener;
import org.linphone.core.LinphoneChatRoom;
import org.linphone.core.LinphoneContent;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCore.EcCalibratorStatus;
import org.linphone.core.LinphoneCore.GlobalState;
import org.linphone.core.LinphoneCore.LogCollectionUploadState;
import org.linphone.core.LinphoneCore.RegistrationState;
import org.linphone.core.LinphoneCore.RemoteProvisioningState;
import org.linphone.core.LinphoneCoreException;
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.core.LinphoneCoreListener;
import org.linphone.core.LinphoneEvent;
import org.linphone.core.LinphoneFriend;
import org.linphone.core.LinphoneInfoMessage;
import org.linphone.core.LinphoneProxyConfig;
import org.linphone.core.PublishState;
import org.linphone.core.SubscriptionState;

import java.nio.ByteBuffer;

/*   4:    */
/*   5:    */
/*   6:    */
/*   7:    */
/*   8:    */
/*  10:    */
/*  11:    */
/*  12:    */
/*  13:    */
/*  14:    */
/*  15:    */
/*  16:    */
/*  17:    */
/*  18:    */
/*  19:    */
/*  20:    */
/*  21:    */
/*  22:    */
/*  23:    */
/*  24:    */
/*  25:    */
/*  26:    */
/*  27:    */
/*  28:    */ 
/*  29:    */ public class TutorialChatRoom
/*  30:    */   implements LinphoneCoreListener, StateListener
/*  31:    */ {
/*  32:    */   private boolean running;
/*  33:    */   private TutorialNotifier TutorialNotifier;
/*  34:    */   
/*  35:    */   public TutorialChatRoom(TutorialNotifier TutorialNotifier)
/*  36:    */   {
/*  37: 68 */     this.TutorialNotifier = TutorialNotifier;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public TutorialChatRoom()
/*  41:    */   {
/*  42: 72 */     this.TutorialNotifier = new TutorialNotifier();
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void show(LinphoneCore lc) {}
/*  46:    */   
/*  47:    */   public void byeReceived(LinphoneCore lc, String from) {}
/*  48:    */   
/*  49:    */   public void authInfoRequested(LinphoneCore lc, String realm, String username, String domain) {}
/*  50:    */   
/*  51:    */   public void displayStatus(LinphoneCore lc, String message) {}
/*  52:    */   
/*  53:    */   public void displayMessage(LinphoneCore lc, String message) {}
/*  54:    */   
/*  55:    */   public void displayWarning(LinphoneCore lc, String message) {}
/*  56:    */   
/*  57:    */   public void globalState(LinphoneCore lc, GlobalState state, String message) {}
/*  58:    */   
/*  59:    */   public void registrationState(LinphoneCore lc, LinphoneProxyConfig cfg, RegistrationState cstate, String smessage) {}
/*  60:    */   
/*  61:    */   public void newSubscriptionRequest(LinphoneCore lc, LinphoneFriend lf, String url) {}
/*  62:    */   
/*  63:    */   public void notifyPresenceReceived(LinphoneCore lc, LinphoneFriend lf) {}
/*  64:    */   
/*  65:    */   public void callState(LinphoneCore lc, LinphoneCall call, LinphoneCall.State cstate, String msg) {}
/*  66:    */   
/*  67:    */   public void callStatsUpdated(LinphoneCore lc, LinphoneCall call, LinphoneCallStats stats) {}
/*  68:    */   
/*  69:    */   public void ecCalibrationStatus(LinphoneCore lc, EcCalibratorStatus status, int delay_ms, Object data) {}
/*  70:    */   
/*  71:    */   public void callEncryptionChanged(LinphoneCore lc, LinphoneCall call, boolean encrypted, String authenticationToken) {}
/*  72:    */   
/*  73:    */   public void notifyReceived(LinphoneCore lc, LinphoneCall call, LinphoneAddress from, byte[] event) {}
/*  74:    */   
/*  75:    */   public void dtmfReceived(LinphoneCore lc, LinphoneCall call, int dtmf) {}
/*  76:    */   
/*  77:    */   public void textReceived(LinphoneCore lc, LinphoneChatRoom cr, LinphoneAddress from, String message) {}
/*  78:    */   
/*  79:    */   public static void main(String[] args)
/*  80:    */   {
/*  81:103 */     if (args.length != 1) {
/*  82:104 */       throw new IllegalArgumentException("Bad number of arguments");
/*  83:    */     }
/*  84:108 */     TutorialChatRoom tutorial = new TutorialChatRoom();
/*  85:    */     try
/*  86:    */     {
/*  87:110 */       String destinationSipAddress = args[1];
/*  88:111 */       tutorial.launchTutorial(destinationSipAddress);
/*  89:    */     }
/*  90:    */     catch (Exception e)
/*  91:    */     {
/*  92:113 */       e.printStackTrace();
/*  93:    */     }
/*  94:    */   }
/*  95:    */   
/*  96:    */   public void launchTutorial(String destinationSipAddress)
/*  97:    */     throws LinphoneCoreException
/*  98:    */   {
/*  99:123 */     LinphoneCore lc = LinphoneCoreFactory.instance().createLinphoneCore(this, null);
/* 100:    */     try
/* 101:    */     {
/* 102:127 */       LinphoneChatRoom chatRoom = lc.getOrCreateChatRoom(destinationSipAddress);
/* 103:    */       
/* 104:    */ 
/* 105:130 */       LinphoneChatMessage chatMessage = chatRoom.createLinphoneChatMessage("Hello world");
/* 106:131 */       chatRoom.sendMessage(chatMessage, this);
/* 107:    */       
/* 108:    */ 
/* 109:134 */       this.running = true;
/* 110:135 */       while (this.running)
/* 111:    */       {
/* 112:136 */         lc.iterate();
/* 113:    */         try
/* 114:    */         {
/* 115:138 */           Thread.sleep(50L);
/* 116:    */         }
/* 117:    */         catch (InterruptedException ie)
/* 118:    */         {
/* 119:140 */           write("Interrupted!\nAborting");
/* 120:    */         }
/* 121:    */       }
/* 122:    */     }
/* 123:    */     finally
/* 124:    */     {
/* 125:146 */       write("Shutting down...");
/* 126:    */       
/* 127:148 */       lc.destroy();
/* 128:149 */       write("Exited");
/* 129:    */     }
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void stopMainLoop()
/* 133:    */   {
/* 134:155 */     this.running = false;
/* 135:    */   }
/* 136:    */   
/* 137:    */   private void write(String s)
/* 138:    */   {
/* 139:160 */     this.TutorialNotifier.notify(s);
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void messageReceived(LinphoneCore lc, LinphoneChatRoom cr, LinphoneChatMessage message)
/* 143:    */   {
/* 144:166 */     write("Message [" + message.getText() + "] received from [" + message.getFrom().asString() + "]");
/* 145:    */   }
/* 146:    */   
/* 147:    */   public void onLinphoneChatMessageStateChanged(LinphoneChatMessage msg, State state)
/* 148:    */   {
/* 149:172 */     write("Sent message [" + msg.getText() + "] new state is " + state.toString());
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void transferState(LinphoneCore lc, LinphoneCall call, LinphoneCall.State new_call_state) {}
/* 153:    */   
/* 154:    */   public void infoReceived(LinphoneCore lc, LinphoneCall call, LinphoneInfoMessage info) {}
/* 155:    */   
/* 156:    */   public void subscriptionStateChanged(LinphoneCore lc, LinphoneEvent ev, SubscriptionState state) {}
/* 157:    */   
/* 158:    */   public void notifyReceived(LinphoneCore lc, LinphoneEvent ev, String eventName, LinphoneContent content) {}
/* 159:    */   
/* 160:    */   public void publishStateChanged(LinphoneCore lc, LinphoneEvent ev, PublishState state) {}
/* 161:    */   
/* 162:    */   public void isComposingReceived(LinphoneCore lc, LinphoneChatRoom cr)
/* 163:    */   {
/* 164:211 */     if (cr.isRemoteComposing()) {
/* 165:212 */       write("Remote is writing a message");
/* 166:    */     } else {
/* 167:214 */       write("Remote has stop writing");
/* 168:    */     }
/* 169:    */   }
/* 170:    */   
/* 171:    */   public void configuringStatus(LinphoneCore lc, RemoteProvisioningState state, String message) {}
/* 172:    */   
/* 173:    */   public void fileTransferProgressIndication(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, int progress) {}
/* 174:    */   
/* 175:    */   public void fileTransferRecv(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, byte[] buffer, int size) {}
/* 176:    */   
/* 177:    */   public int fileTransferSend(LinphoneCore lc, LinphoneChatMessage message, LinphoneContent content, ByteBuffer buffer, int size)
/* 178:    */   {
/* 179:242 */     return 0;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public void uploadProgressIndication(LinphoneCore lc, int offset, int total) {}
/* 183:    */   
/* 184:    */   public void uploadStateChanged(LinphoneCore lc, LogCollectionUploadState state, String info) {}

    @Override
    public void onLinphoneChatMessageStateChanged(LinphoneChatMessage paramLinphoneChatMessage, LinphoneChatMessage.State paramState) {

    }
/* 185:    */ }

