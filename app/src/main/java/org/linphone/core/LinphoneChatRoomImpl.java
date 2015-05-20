/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ class LinphoneChatRoomImpl
/*   4:    */   implements LinphoneChatRoom
/*   5:    */ {
/*   6:    */   protected final long nativePtr;
/*   7:    */   
/*   8:    */   private native long createLinphoneChatMessage(long paramLong, String paramString);
/*   9:    */   
/*  10:    */   private native long getPeerAddress(long paramLong);
/*  11:    */   
/*  12:    */   private native void sendMessage(long paramLong, String paramString);
/*  13:    */   
/*  14:    */   private native void sendMessage2(long paramLong1, Object paramObject, long paramLong2, LinphoneChatMessage.StateListener paramStateListener);
/*  15:    */   
/*  16:    */   private native long[] getHistoryRange(long paramLong, int paramInt1, int paramInt2);
/*  17:    */   
/*  18:    */   private native long[] getHistory(long paramLong, int paramInt);
/*  19:    */   
/*  20:    */   private native void destroy(long paramLong);
/*  21:    */   
/*  22:    */   private native int getUnreadMessagesCount(long paramLong);
/*  23:    */   
/*  24:    */   private native int getHistorySize(long paramLong);
/*  25:    */   
/*  26:    */   private native void deleteHistory(long paramLong);
/*  27:    */   
/*  28:    */   private native void compose(long paramLong);
/*  29:    */   
/*  30:    */   private native boolean isRemoteComposing(long paramLong);
/*  31:    */   
/*  32:    */   private native void markAsRead(long paramLong);
/*  33:    */   
/*  34:    */   private native void deleteMessage(long paramLong1, long paramLong2);
/*  35:    */   
/*  36:    */   private native void updateUrl(long paramLong1, long paramLong2);
/*  37:    */   
/*  38:    */   private native long createLinphoneChatMessage2(long paramLong1, String paramString1, String paramString2, int paramInt, long paramLong2, boolean paramBoolean1, boolean paramBoolean2);
/*  39:    */   
/*  40:    */   private native void sendChatMessage(long paramLong1, Object paramObject, long paramLong2);
/*  41:    */   
/*  42:    */   protected LinphoneChatRoomImpl(long aNativePtr)
/*  43:    */   {
/*  44: 48 */     this.nativePtr = aNativePtr;
/*  45:    */   }
/*  46:    */   
/*  47:    */   public LinphoneAddress getPeerAddress()
/*  48:    */   {
/*  49: 52 */     return new LinphoneAddressImpl(getPeerAddress(this.nativePtr), LinphoneAddressImpl.WrapMode.FromConst);
/*  50:    */   }
/*  51:    */   
/*  52:    */   public void sendMessage(String message)
/*  53:    */   {
/*  54: 56 */     synchronized (getCore())
/*  55:    */     {
/*  56: 57 */       sendMessage(this.nativePtr, message);
/*  57:    */     }
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void sendMessage(LinphoneChatMessage message, LinphoneChatMessage.StateListener listener)
/*  61:    */   {
/*  62: 63 */     synchronized (getCore())
/*  63:    */     {
/*  64: 64 */       sendMessage2(this.nativePtr, message, ((LinphoneChatMessageImpl)message).getNativePtr(), listener);
/*  65:    */     }
/*  66:    */   }
/*  67:    */   
/*  68:    */   public LinphoneChatMessage createLinphoneChatMessage(String message)
/*  69:    */   {
/*  70: 70 */     synchronized (getCore())
/*  71:    */     {
/*  72: 71 */       return new LinphoneChatMessageImpl(createLinphoneChatMessage(this.nativePtr, message));
/*  73:    */     }
/*  74:    */   }
/*  75:    */   
/*  76:    */   public LinphoneChatMessage[] getHistory()
/*  77:    */   {
/*  78: 76 */     synchronized (getCore())
/*  79:    */     {
/*  80: 77 */       return getHistory(0);
/*  81:    */     }
/*  82:    */   }
/*  83:    */   
/*  84:    */   public LinphoneChatMessage[] getHistoryRange(int begin, int end)
/*  85:    */   {
/*  86: 82 */     synchronized (getCore())
/*  87:    */     {
/*  88: 83 */       long[] typesPtr = getHistoryRange(this.nativePtr, begin, end);
/*  89: 84 */       return getHistoryPrivate(typesPtr);
/*  90:    */     }
/*  91:    */   }
/*  92:    */   
/*  93:    */   public LinphoneChatMessage[] getHistory(int limit)
/*  94:    */   {
/*  95: 89 */     synchronized (getCore())
/*  96:    */     {
/*  97: 90 */       long[] typesPtr = getHistory(this.nativePtr, limit);
/*  98: 91 */       return getHistoryPrivate(typesPtr);
/*  99:    */     }
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void destroy()
/* 103:    */   {
/* 104: 96 */     destroy(this.nativePtr);
/* 105:    */   }
/* 106:    */   
/* 107:    */   public int getUnreadMessagesCount()
/* 108:    */   {
/* 109:100 */     synchronized (getCore())
/* 110:    */     {
/* 111:101 */       return getUnreadMessagesCount(this.nativePtr);
/* 112:    */     }
/* 113:    */   }
/* 114:    */   
/* 115:    */   public int getHistorySize()
/* 116:    */   {
/* 117:106 */     synchronized (getCore())
/* 118:    */     {
/* 119:107 */       return getHistorySize(this.nativePtr);
/* 120:    */     }
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void deleteHistory()
/* 124:    */   {
/* 125:112 */     synchronized (getCore())
/* 126:    */     {
/* 127:113 */       deleteHistory(this.nativePtr);
/* 128:    */     }
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void compose()
/* 132:    */   {
/* 133:118 */     synchronized (getCore())
/* 134:    */     {
/* 135:119 */       compose(this.nativePtr);
/* 136:    */     }
/* 137:    */   }
/* 138:    */   
/* 139:    */   public boolean isRemoteComposing()
/* 140:    */   {
/* 141:124 */     synchronized (getCore())
/* 142:    */     {
/* 143:125 */       return isRemoteComposing(this.nativePtr);
/* 144:    */     }
/* 145:    */   }
/* 146:    */   
/* 147:    */   public void markAsRead()
/* 148:    */   {
/* 149:130 */     synchronized (getCore())
/* 150:    */     {
/* 151:131 */       markAsRead(this.nativePtr);
/* 152:    */     }
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void deleteMessage(LinphoneChatMessage message)
/* 156:    */   {
/* 157:136 */     synchronized (getCore())
/* 158:    */     {
/* 159:137 */       if (message != null) {
/* 160:138 */         deleteMessage(this.nativePtr, ((LinphoneChatMessageImpl)message).getNativePtr());
/* 161:    */       }
/* 162:    */     }
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void updateUrl(LinphoneChatMessage message)
/* 166:    */   {
/* 167:143 */     synchronized (getCore())
/* 168:    */     {
/* 169:144 */       if (message != null) {
/* 170:145 */         updateUrl(this.nativePtr, ((LinphoneChatMessageImpl)message).getNativePtr());
/* 171:    */       }
/* 172:    */     }
/* 173:    */   }
/* 174:    */   
/* 175:    */   public LinphoneChatMessage createLinphoneChatMessage(String message, String url, LinphoneChatMessage.State state, long timestamp, boolean isRead, boolean isIncoming)
/* 176:    */   {
/* 177:153 */     synchronized (getCore())
/* 178:    */     {
/* 179:154 */       return new LinphoneChatMessageImpl(createLinphoneChatMessage2(this.nativePtr, message, url, state.value(), timestamp / 1000L, isRead, isIncoming));
/* 180:    */     }
/* 181:    */   }
/* 182:    */   
/* 183:    */   private native Object getCore(long paramLong);
/* 184:    */   
/* 185:    */   public synchronized LinphoneCore getCore()
/* 186:    */   {
/* 187:161 */     return (LinphoneCore)getCore(this.nativePtr);
/* 188:    */   }
/* 189:    */   
/* 190:    */   private LinphoneChatMessage[] getHistoryPrivate(long[] typesPtr)
/* 191:    */   {
/* 192:164 */     if (typesPtr == null) {
/* 193:164 */       return null;
/* 194:    */     }
/* 195:166 */     LinphoneChatMessage[] messages = new LinphoneChatMessage[typesPtr.length];
/* 196:167 */     for (int i = 0; i < messages.length; i++) {
/* 197:168 */       messages[i] = new LinphoneChatMessageImpl(typesPtr[i]);
/* 198:    */     }
/* 199:171 */     return messages;
/* 200:    */   }
/* 201:    */   
/* 202:    */   private native long createFileTransferMessage(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt);
/* 203:    */   
/* 204:    */   public LinphoneChatMessage createFileTransferMessage(LinphoneContent content)
/* 205:    */   {
/* 206:177 */     synchronized (getCore())
/* 207:    */     {
/* 208:178 */       return new LinphoneChatMessageImpl(createFileTransferMessage(this.nativePtr, content.getName(), content.getType(), content.getSubtype(), content.getRealSize()));
/* 209:    */     }
/* 210:    */   }
/* 211:    */   
/* 212:    */   public void sendChatMessage(LinphoneChatMessage message)
/* 213:    */   {
/* 214:183 */     sendChatMessage(this.nativePtr, message, ((LinphoneChatMessageImpl)message).getNativePtr());
/* 215:    */   }
/* 216:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneChatRoomImpl
 * JD-Core Version:    0.7.0.1
 */