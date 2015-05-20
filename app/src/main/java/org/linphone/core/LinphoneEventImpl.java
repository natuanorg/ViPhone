/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ public class LinphoneEventImpl
/*   4:    */   implements LinphoneEvent
/*   5:    */ {
/*   6:    */   private Object mUserContext;
/*   7:    */   private long mNativePtr;
/*   8:    */   
/*   9:    */   protected LinphoneEventImpl(long nativePtr)
/*  10:    */   {
/*  11:  9 */     this.mNativePtr = nativePtr;
/*  12:    */   }
/*  13:    */   
/*  14:    */   private native String getEventName(long paramLong);
/*  15:    */   
/*  16:    */   public synchronized String getEventName()
/*  17:    */   {
/*  18: 15 */     return getEventName(this.mNativePtr);
/*  19:    */   }
/*  20:    */   
/*  21:    */   private native int acceptSubscription(long paramLong);
/*  22:    */   
/*  23:    */   public synchronized void acceptSubscription()
/*  24:    */   {
/*  25: 21 */     synchronized (getCore())
/*  26:    */     {
/*  27: 22 */       acceptSubscription(this.mNativePtr);
/*  28:    */     }
/*  29:    */   }
/*  30:    */   
/*  31:    */   private native int denySubscription(long paramLong, int paramInt);
/*  32:    */   
/*  33:    */   public synchronized void denySubscription(Reason reason)
/*  34:    */   {
/*  35: 29 */     synchronized (getCore())
/*  36:    */     {
/*  37: 30 */       denySubscription(this.mNativePtr, reason.mValue);
/*  38:    */     }
/*  39:    */   }
/*  40:    */   
/*  41:    */   private native int notify(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3);
/*  42:    */   
/*  43:    */   public void notify(LinphoneContent content)
/*  44:    */   {
/*  45: 37 */     synchronized (getCore())
/*  46:    */     {
/*  47: 38 */       notify(this.mNativePtr, content.getType(), content.getSubtype(), content.getData(), content.getEncoding());
/*  48:    */     }
/*  49:    */   }
/*  50:    */   
/*  51:    */   private native int updateSubscribe(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3);
/*  52:    */   
/*  53:    */   public void updateSubscribe(LinphoneContent content)
/*  54:    */   {
/*  55: 45 */     synchronized (getCore())
/*  56:    */     {
/*  57: 46 */       updateSubscribe(this.mNativePtr, content.getType(), content.getSubtype(), content.getData(), content.getEncoding());
/*  58:    */     }
/*  59:    */   }
/*  60:    */   
/*  61:    */   private native int updatePublish(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3);
/*  62:    */   
/*  63:    */   public void updatePublish(LinphoneContent content)
/*  64:    */   {
/*  65: 53 */     synchronized (getCore())
/*  66:    */     {
/*  67: 54 */       updatePublish(this.mNativePtr, content.getType(), content.getSubtype(), content.getData(), content.getEncoding());
/*  68:    */     }
/*  69:    */   }
/*  70:    */   
/*  71:    */   private native int terminate(long paramLong);
/*  72:    */   
/*  73:    */   public void terminate()
/*  74:    */   {
/*  75: 61 */     synchronized (getCore())
/*  76:    */     {
/*  77: 62 */       terminate(this.mNativePtr);
/*  78:    */     }
/*  79:    */   }
/*  80:    */   
/*  81:    */   private native int getReason(long paramLong);
/*  82:    */   
/*  83:    */   public synchronized Reason getReason()
/*  84:    */   {
/*  85: 69 */     return Reason.fromInt(getReason(this.mNativePtr));
/*  86:    */   }
/*  87:    */   
/*  88:    */   public synchronized void setUserContext(Object obj)
/*  89:    */   {
/*  90: 74 */     this.mUserContext = obj;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public synchronized Object getUserContext()
/*  94:    */   {
/*  95: 79 */     return this.mUserContext;
/*  96:    */   }
/*  97:    */   
/*  98:    */   private native int getSubscriptionDir(long paramLong);
/*  99:    */   
/* 100:    */   public synchronized SubscriptionDir getSubscriptionDir()
/* 101:    */   {
/* 102: 85 */     return SubscriptionDir.fromInt(getSubscriptionDir(this.mNativePtr));
/* 103:    */   }
/* 104:    */   
/* 105:    */   private native int getSubscriptionState(long paramLong);
/* 106:    */   
/* 107:    */   public synchronized SubscriptionState getSubscriptionState()
/* 108:    */   {
/* 109:    */     try
/* 110:    */     {
/* 111: 92 */       return SubscriptionState.fromInt(getSubscriptionState(this.mNativePtr));
/* 112:    */     }
/* 113:    */     catch (LinphoneCoreException e)
/* 114:    */     {
/* 115: 95 */       e.printStackTrace();
/* 116:    */     }
/* 117: 97 */     return SubscriptionState.Error;
/* 118:    */   }
/* 119:    */   
/* 120:    */   private native void unref(long paramLong);
/* 121:    */   
/* 122:    */   protected void finalize()
/* 123:    */   {
/* 124:101 */     unref(this.mNativePtr);
/* 125:    */   }
/* 126:    */   
/* 127:    */   private native void addCustomHeader(long paramLong, String paramString1, String paramString2);
/* 128:    */   
/* 129:    */   public synchronized void addCustomHeader(String name, String value)
/* 130:    */   {
/* 131:107 */     addCustomHeader(this.mNativePtr, name, value);
/* 132:    */   }
/* 133:    */   
/* 134:    */   private native String getCustomHeader(long paramLong, String paramString);
/* 135:    */   
/* 136:    */   public synchronized String getCustomHeader(String name)
/* 137:    */   {
/* 138:113 */     return getCustomHeader(this.mNativePtr, name);
/* 139:    */   }
/* 140:    */   
/* 141:    */   private native void sendSubscribe(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3);
/* 142:    */   
/* 143:    */   public void sendSubscribe(LinphoneContent body)
/* 144:    */   {
/* 145:119 */     synchronized (getCore())
/* 146:    */     {
/* 147:120 */       if (body != null) {
/* 148:121 */         sendSubscribe(this.mNativePtr, body.getType(), body.getSubtype(), body.getData(), body.getEncoding());
/* 149:    */       } else {
/* 150:123 */         sendSubscribe(this.mNativePtr, null, null, null, null);
/* 151:    */       }
/* 152:    */     }
/* 153:    */   }
/* 154:    */   
/* 155:    */   private native void sendPublish(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3);
/* 156:    */   
/* 157:    */   public void sendPublish(LinphoneContent body)
/* 158:    */   {
/* 159:130 */     synchronized (getCore())
/* 160:    */     {
/* 161:131 */       if (body != null) {
/* 162:132 */         sendPublish(this.mNativePtr, body.getType(), body.getSubtype(), body.getData(), body.getEncoding());
/* 163:    */       } else {
/* 164:134 */         sendPublish(this.mNativePtr, null, null, null, null);
/* 165:    */       }
/* 166:    */     }
/* 167:    */   }
/* 168:    */   
/* 169:    */   private native long getErrorInfo(long paramLong);
/* 170:    */   
/* 171:    */   public synchronized ErrorInfo getErrorInfo()
/* 172:    */   {
/* 173:140 */     return new ErrorInfoImpl(getErrorInfo(this.mNativePtr));
/* 174:    */   }
/* 175:    */   
/* 176:    */   private native Object getCore(long paramLong);
/* 177:    */   
/* 178:    */   public synchronized LinphoneCore getCore()
/* 179:    */   {
/* 180:146 */     return (LinphoneCore)getCore(this.mNativePtr);
/* 181:    */   }
/* 182:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneEventImpl
 * JD-Core Version:    0.7.0.1
 */