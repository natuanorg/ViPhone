/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ import java.util.Vector;
/*  4:   */ 
/*  5:   */ public abstract interface LinphoneChatMessage
/*  6:   */ {
/*  7:   */   public abstract String getText();
/*  8:   */   
/*  9:   */   public abstract LinphoneAddress getPeerAddress();
/* 10:   */   
/* 11:   */   public abstract LinphoneAddress getFrom();
/* 12:   */   
/* 13:   */   public abstract LinphoneAddress getTo();
/* 14:   */   
/* 15:   */   public abstract String getExternalBodyUrl();
/* 16:   */   
/* 17:   */   public abstract void setExternalBodyUrl(String paramString);
/* 18:   */   
/* 19:   */   public abstract void addCustomHeader(String paramString1, String paramString2);
/* 20:   */   
/* 21:   */   public abstract String getCustomHeader(String paramString);
/* 22:   */   
/* 23:   */   public abstract long getTime();
/* 24:   */   
/* 25:   */   public abstract State getStatus();
/* 26:   */   
/* 27:   */   public abstract boolean isRead();
/* 28:   */   
/* 29:   */   public abstract boolean isOutgoing();
/* 30:   */   
/* 31:   */   public abstract void store();
/* 32:   */   
/* 33:   */   public abstract int getStorageId();
/* 34:   */   
/* 35:   */   public abstract Reason getReason();
/* 36:   */   
/* 37:   */   public abstract ErrorInfo getErrorInfo();
/* 38:   */   
/* 39:   */   public abstract void cancelFileTransfer();
/* 40:   */   
/* 41:   */   public abstract LinphoneContent getFileTransferInformation();
/* 42:   */   
/* 43:   */   public abstract void setAppData(String paramString);
/* 44:   */   
/* 45:   */   public abstract String getAppData();
/* 46:   */   
/* 47:   */   public abstract void setFileTransferFilepath(String paramString);
/* 48:   */   
/* 49:   */   public abstract void downloadFile();
/* 50:   */   
/* 51:   */   public abstract void setListener(LinphoneChatMessageListener paramLinphoneChatMessageListener);
/* 52:   */   
/* 53:   */   public static class State
/* 54:   */   {
/* 55:40 */     private static Vector<State> values = new Vector();
/* 56:   */     private final int mValue;
/* 57:   */     private final String mStringValue;
/* 58:   */     
/* 59:   */     public final int value()
/* 60:   */     {
/* 61:42 */       return this.mValue;
/* 62:   */     }
/* 63:   */     
/* 64:48 */     public static final State Idle = new State(0, "Idle");
/* 65:52 */     public static final State InProgress = new State(1, "InProgress");
/* 66:56 */     public static final State Delivered = new State(2, "Delivered");
/* 67:60 */     public static final State NotDelivered = new State(3, "NotDelivered");
/* 68:64 */     public static final State FileTransferError = new State(4, "FileTransferError");
/* 69:68 */     public static final State FileTransferDone = new State(5, "FileTransferDone");
/* 70:   */     
/* 71:   */     private State(int value, String stringValue)
/* 72:   */     {
/* 73:71 */       this.mValue = value;
/* 74:72 */       values.addElement(this);
/* 75:73 */       this.mStringValue = stringValue;
/* 76:   */     }
/* 77:   */     
/* 78:   */     public static State fromInt(int value)
/* 79:   */     {
/* 80:78 */       for (int i = 0; i < values.size(); i++)
/* 81:   */       {
/* 82:79 */         State state = (State)values.elementAt(i);
/* 83:80 */         if (state.mValue == value) {
/* 84:80 */           return state;
/* 85:   */         }
/* 86:   */       }
/* 87:82 */       throw new RuntimeException("state not found [" + value + "]");
/* 88:   */     }
/* 89:   */     
/* 90:   */     public String toString()
/* 91:   */     {
/* 92:85 */       return this.mStringValue;
/* 93:   */     }
/* 94:   */     
/* 95:   */     public int toInt()
/* 96:   */     {
/* 97:88 */       return this.mValue;
/* 98:   */     }
/* 99:   */   }
/* :0:   */   
/* :1:   */   public static abstract interface LinphoneChatMessageListener
/* :2:   */   {
/* :3:   */     public abstract void onLinphoneChatMessageStateChanged(LinphoneChatMessage paramLinphoneChatMessage, State paramState);
/* :4:   */     
/* :5:   */     public abstract void onLinphoneChatMessageFileTransferReceived(LinphoneChatMessage paramLinphoneChatMessage, LinphoneContent paramLinphoneContent, LinphoneBuffer paramLinphoneBuffer);
/* :6:   */     
/* :7:   */     public abstract void onLinphoneChatMessageFileTransferSent(LinphoneChatMessage paramLinphoneChatMessage, LinphoneContent paramLinphoneContent, int paramInt1, int paramInt2, LinphoneBuffer paramLinphoneBuffer);
/* :8:   */     
/* :9:   */     public abstract void onLinphoneChatMessageFileTransferProgressChanged(LinphoneChatMessage paramLinphoneChatMessage, LinphoneContent paramLinphoneContent, int paramInt1, int paramInt2);
/* ;0:   */   }
/* ;1:   */   
/* ;2:   */   @Deprecated
/* ;3:   */   public static abstract interface StateListener
/* ;4:   */   {
/* ;5:   */     public abstract void onLinphoneChatMessageStateChanged(LinphoneChatMessage paramLinphoneChatMessage, State paramState);
/* ;6:   */   }
/* ;7:   */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.LinphoneChatMessage

 * JD-Core Version:    0.7.0.1

 */