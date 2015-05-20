/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ import java.io.UnsupportedEncodingException;
/*   4:    */ 
/*   5:    */ public class LinphoneChatMessageImpl
/*   6:    */   implements LinphoneChatMessage
/*   7:    */ {
/*   8:    */   protected final long nativePtr;
/*   9:    */   
/*  10:    */   private native byte[] getText(long paramLong);
/*  11:    */   
/*  12:    */   private native long getPeerAddress(long paramLong);
/*  13:    */   
/*  14:    */   private native String getExternalBodyUrl(long paramLong);
/*  15:    */   
/*  16:    */   private native void setExternalBodyUrl(long paramLong, String paramString);
/*  17:    */   
/*  18:    */   private native long getFrom(long paramLong);
/*  19:    */   
/*  20:    */   private native long getTime(long paramLong);
/*  21:    */   
/*  22:    */   private native int getStatus(long paramLong);
/*  23:    */   
/*  24:    */   private native boolean isRead(long paramLong);
/*  25:    */   
/*  26:    */   private native boolean isOutgoing(long paramLong);
/*  27:    */   
/*  28:    */   private native void store(long paramLong);
/*  29:    */   
/*  30:    */   private native int getStorageId(long paramLong);
/*  31:    */   
/*  32:    */   private native void setFileTransferFilepath(long paramLong, String paramString);
/*  33:    */   
/*  34:    */   private native void downloadFile(long paramLong);
/*  35:    */   
/*  36:    */   private native void setListener(long paramLong, LinphoneChatMessageListener paramLinphoneChatMessageListener);
/*  37:    */   
/*  38:    */   private native void unref(long paramLong);
/*  39:    */   
/*  40:    */   protected LinphoneChatMessageImpl(long aNativePtr)
/*  41:    */   {
/*  42: 24 */     this.nativePtr = aNativePtr;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public long getNativePtr()
/*  46:    */   {
/*  47: 28 */     return this.nativePtr;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public String getText()
/*  51:    */   {
/*  52:    */     try
/*  53:    */     {
/*  54: 35 */       byte[] rawText = getText(this.nativePtr);
/*  55: 36 */       if (rawText != null) {
/*  56: 36 */         return new String(rawText, "UTF-8");
/*  57:    */       }
/*  58:    */     }
/*  59:    */     catch (UnsupportedEncodingException e)
/*  60:    */     {
/*  61: 38 */       e.printStackTrace();
/*  62:    */     }
/*  63: 40 */     return null;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public LinphoneAddress getPeerAddress()
/*  67:    */   {
/*  68: 45 */     return new LinphoneAddressImpl(getPeerAddress(this.nativePtr), LinphoneAddressImpl.WrapMode.FromConst);
/*  69:    */   }
/*  70:    */   
/*  71:    */   public String getExternalBodyUrl()
/*  72:    */   {
/*  73: 50 */     return getExternalBodyUrl(this.nativePtr);
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void setExternalBodyUrl(String url)
/*  77:    */   {
/*  78: 55 */     setExternalBodyUrl(this.nativePtr, url);
/*  79:    */   }
/*  80:    */   
/*  81:    */   public LinphoneAddress getFrom()
/*  82:    */   {
/*  83: 60 */     return new LinphoneAddressImpl(getFrom(this.nativePtr), LinphoneAddressImpl.WrapMode.FromConst);
/*  84:    */   }
/*  85:    */   
/*  86:    */   private native long getTo(long paramLong);
/*  87:    */   
/*  88:    */   public LinphoneAddress getTo()
/*  89:    */   {
/*  90: 66 */     return new LinphoneAddressImpl(getTo(this.nativePtr), LinphoneAddressImpl.WrapMode.FromConst);
/*  91:    */   }
/*  92:    */   
/*  93:    */   private native void addCustomHeader(long paramLong, String paramString1, String paramString2);
/*  94:    */   
/*  95:    */   public void addCustomHeader(String name, String value)
/*  96:    */   {
/*  97: 72 */     addCustomHeader(this.nativePtr, name, value);
/*  98:    */   }
/*  99:    */   
/* 100:    */   private native String getCustomHeader(long paramLong, String paramString);
/* 101:    */   
/* 102:    */   public String getCustomHeader(String name)
/* 103:    */   {
/* 104: 77 */     return getCustomHeader(this.nativePtr, name);
/* 105:    */   }
/* 106:    */   
/* 107:    */   public long getTime()
/* 108:    */   {
/* 109: 81 */     return getTime(this.nativePtr) * 1000L;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public State getStatus()
/* 113:    */   {
/* 114: 85 */     return State.fromInt(getStatus(this.nativePtr));
/* 115:    */   }
/* 116:    */   
/* 117:    */   public boolean isRead()
/* 118:    */   {
/* 119: 89 */     return isRead(this.nativePtr);
/* 120:    */   }
/* 121:    */   
/* 122:    */   public boolean isOutgoing()
/* 123:    */   {
/* 124: 93 */     return isOutgoing(this.nativePtr);
/* 125:    */   }
/* 126:    */   
/* 127:    */   public void store()
/* 128:    */   {
/* 129: 97 */     store(this.nativePtr);
/* 130:    */   }
/* 131:    */   
/* 132:    */   public int getStorageId()
/* 133:    */   {
/* 134:101 */     return getStorageId(this.nativePtr);
/* 135:    */   }
/* 136:    */   
/* 137:    */   private native int getReason(long paramLong);
/* 138:    */   
/* 139:    */   public Reason getReason()
/* 140:    */   {
/* 141:107 */     return Reason.fromInt(getReason(this.nativePtr));
/* 142:    */   }
/* 143:    */   
/* 144:    */   private native long getErrorInfo(long paramLong);
/* 145:    */   
/* 146:    */   public ErrorInfo getErrorInfo()
/* 147:    */   {
/* 148:112 */     return new ErrorInfoImpl(getErrorInfo(this.nativePtr));
/* 149:    */   }
/* 150:    */   
/* 151:    */   protected void finalize()
/* 152:    */     throws Throwable
/* 153:    */   {
/* 154:115 */     unref(this.nativePtr);
/* 155:116 */     super.finalize();
/* 156:    */   }
/* 157:    */   
/* 158:    */   private native Object getFileTransferInformation(long paramLong);
/* 159:    */   
/* 160:    */   public LinphoneContent getFileTransferInformation()
/* 161:    */   {
/* 162:122 */     return (LinphoneContent)getFileTransferInformation(this.nativePtr);
/* 163:    */   }
/* 164:    */   
/* 165:    */   private native void setAppData(long paramLong, String paramString);
/* 166:    */   
/* 167:    */   public void setAppData(String data)
/* 168:    */   {
/* 169:128 */     setAppData(this.nativePtr, data);
/* 170:    */   }
/* 171:    */   
/* 172:    */   private native String getAppData(long paramLong);
/* 173:    */   
/* 174:    */   public String getAppData()
/* 175:    */   {
/* 176:134 */     return getAppData(this.nativePtr);
/* 177:    */   }
/* 178:    */   
/* 179:    */   private native void cancelFileTransfer(long paramLong);
/* 180:    */   
/* 181:    */   public void cancelFileTransfer()
/* 182:    */   {
/* 183:140 */     cancelFileTransfer(this.nativePtr);
/* 184:    */   }
/* 185:    */   
/* 186:    */   public void setFileTransferFilepath(String path)
/* 187:    */   {
/* 188:145 */     setFileTransferFilepath(this.nativePtr, path);
/* 189:    */   }
/* 190:    */   
/* 191:    */   public void downloadFile()
/* 192:    */   {
/* 193:150 */     downloadFile(this.nativePtr);
/* 194:    */   }
/* 195:    */   
/* 196:    */   public void setListener(LinphoneChatMessageListener listener)
/* 197:    */   {
/* 198:155 */     setListener(this.nativePtr, listener);
/* 199:    */   }
/* 200:    */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.LinphoneChatMessageImpl

 * JD-Core Version:    0.7.0.1

 */