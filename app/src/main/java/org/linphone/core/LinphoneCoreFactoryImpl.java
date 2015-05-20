/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ import android.util.Log;

import org.linphone.mediastream.MediastreamerAndroidContext;
import org.linphone.mediastream.Version;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*   4:    */
/*   5:    */
/*   6:    */
/*   7:    */
/*   8:    */
/*   9:    */ 
/*  10:    */ public class LinphoneCoreFactoryImpl
/*  11:    */   extends LinphoneCoreFactory
/*  12:    */ {
/*  13:    */   private static boolean loadOptionalLibrary(String s)
/*  14:    */   {
/*  15:    */     try
/*  16:    */     {
/*  17: 34 */       System.loadLibrary(s);
/*  18: 35 */       return true;
/*  19:    */     }
/*  20:    */     catch (Throwable e)
/*  21:    */     {
/*  22: 37 */       Log.w("LinphoneCoreFactoryImpl", "Unable to load optional library lib" + s);
/*  23:    */     }
/*  24: 39 */     return false;
/*  25:    */   }
/*  26:    */   
/*  27:    */   static
/*  28:    */   {
/*  29: 43 */     List<String> cpuabis = Version.getCpuAbis();
/*  30:    */     
/*  31: 45 */     boolean libLoaded = false;
/*  32: 46 */     Throwable firstException = null;
/*  33: 47 */     for (String abi : cpuabis)
/*  34:    */     {
/*  35: 48 */       Log.i("LinphoneCoreFactoryImpl", "Trying to load liblinphone for " + abi);
/*  36: 49 */       String ffmpegAbi = abi;
/*  37: 51 */       if (abi.startsWith("armeabi")) {
/*  38: 52 */         ffmpegAbi = "arm";
/*  39:    */       }
/*  40: 54 */       loadOptionalLibrary("ffmpeg-linphone-" + ffmpegAbi);
/*  41:    */       try
/*  42:    */       {
/*  43: 57 */         System.loadLibrary("linphone-" + abi);
/*  44: 58 */         Log.i("LinphoneCoreFactoryImpl", "Loading done with " + abi);
/*  45: 59 */         libLoaded = true;
/*  46:    */       }
/*  47:    */       catch (Throwable e)
/*  48:    */       {
/*  49: 62 */         if (firstException == null) {
/*  50: 62 */           firstException = e;
/*  51:    */         }
/*  52:    */       }
/*  53:    */     }
/*  54: 66 */     if (!libLoaded) {
/*  55: 67 */       throw new RuntimeException(firstException);
/*  56:    */     }
/*  57: 70 */     Version.dumpCapabilities();
/*  58:    */   }
/*  59:    */   
/*  60:    */   public LinphoneAuthInfo createAuthInfo(String username, String password, String realm, String domain)
/*  61:    */   {
/*  62: 76 */     return new LinphoneAuthInfoImpl(username, password, realm, domain);
/*  63:    */   }
/*  64:    */   
/*  65:    */   public LinphoneAddress createLinphoneAddress(String username, String domain, String displayName)
/*  66:    */   {
/*  67: 82 */     return new LinphoneAddressImpl(username, domain, displayName);
/*  68:    */   }
/*  69:    */   
/*  70:    */   public LinphoneAddress createLinphoneAddress(String identity)
/*  71:    */     throws LinphoneCoreException
/*  72:    */   {
/*  73: 87 */     return new LinphoneAddressImpl(identity);
/*  74:    */   }
/*  75:    */   
/*  76:    */   public LpConfig createLpConfig(String file)
/*  77:    */   {
/*  78: 92 */     return new LpConfigImpl(file);
/*  79:    */   }
/*  80:    */   
/*  81:    */   public LinphoneCore createLinphoneCore(LinphoneCoreListener listener, String userConfig, String factoryConfig, Object userdata, Object context)
/*  82:    */     throws LinphoneCoreException
/*  83:    */   {
/*  84:    */     try
/*  85:    */     {
/*  86:100 */       MediastreamerAndroidContext.setContext(context);
/*  87:101 */       File user = userConfig == null ? null : new File(userConfig);
/*  88:102 */       File factory = factoryConfig == null ? null : new File(factoryConfig);
/*  89:103 */       LinphoneCore lc = new LinphoneCoreImpl(listener, user, factory, userdata);
/*  90:104 */       if (context != null) {
/*  91:104 */         lc.setContext(context);
/*  92:    */       }
/*  93:105 */       return lc;
/*  94:    */     }
/*  95:    */     catch (IOException e)
/*  96:    */     {
/*  97:107 */       throw new LinphoneCoreException("Cannot create LinphoneCore", e);
/*  98:    */     }
/*  99:    */   }
/* 100:    */   
/* 101:    */   public LinphoneCore createLinphoneCore(LinphoneCoreListener listener, Object context)
/* 102:    */     throws LinphoneCoreException
/* 103:    */   {
/* 104:    */     try
/* 105:    */     {
/* 106:114 */       MediastreamerAndroidContext.setContext(context);
/* 107:115 */       LinphoneCore lc = new LinphoneCoreImpl(listener);
/* 108:116 */       if (context != null) {
/* 109:116 */         lc.setContext(context);
/* 110:    */       }
/* 111:117 */       return lc;
/* 112:    */     }
/* 113:    */     catch (IOException e)
/* 114:    */     {
/* 115:119 */       throw new LinphoneCoreException("Cannot create LinphoneCore", e);
/* 116:    */     }
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setLogHandler(LinphoneLogHandler handler)
/* 120:    */   {
/* 121:130 */     _setLogHandler(handler);
/* 122:    */   }
/* 123:    */   
/* 124:    */   public LinphoneFriend createLinphoneFriend(String friendUri)
/* 125:    */   {
/* 126:135 */     return new LinphoneFriendImpl(friendUri);
/* 127:    */   }
/* 128:    */   
/* 129:    */   public LinphoneFriend createLinphoneFriend()
/* 130:    */   {
/* 131:140 */     return createLinphoneFriend(null);
/* 132:    */   }
/* 133:    */   
/* 134:    */   public static boolean isArmv7()
/* 135:    */   {
/* 136:151 */     return System.getProperty("os.arch").contains("armv7");
/* 137:    */   }
/* 138:    */   
/* 139:    */   public LinphoneAuthInfo createAuthInfo(String username, String userid, String passwd, String ha1, String realm, String domain)
/* 140:    */   {
/* 141:157 */     return new LinphoneAuthInfoImpl(username, userid, passwd, ha1, realm, domain);
/* 142:    */   }
/* 143:    */   
/* 144:    */   public LinphoneContent createLinphoneContent(String type, String subType, byte[] data, String encoding)
/* 145:    */   {
/* 146:163 */     return new LinphoneContentImpl(type, subType, data, encoding);
/* 147:    */   }
/* 148:    */   
/* 149:    */   public LinphoneContent createLinphoneContent(String type, String subType, String data)
/* 150:    */   {
/* 151:169 */     return new LinphoneContentImpl(type, subType, data == null ? null : data.getBytes(), null);
/* 152:    */   }
/* 153:    */   
/* 154:    */   public PresenceActivity createPresenceActivity(PresenceActivityType type, String description)
/* 155:    */   {
/* 156:174 */     return new PresenceActivityImpl(type, description);
/* 157:    */   }
/* 158:    */   
/* 159:    */   public PresenceService createPresenceService(String id, PresenceBasicStatus status, String contact)
/* 160:    */   {
/* 161:179 */     return new PresenceServiceImpl(id, status, contact);
/* 162:    */   }
/* 163:    */   
/* 164:    */   public PresenceModel createPresenceModel()
/* 165:    */   {
/* 166:184 */     return new PresenceModelImpl();
/* 167:    */   }
/* 168:    */   
/* 169:    */   public PresenceModel createPresenceModel(PresenceActivityType type, String description)
/* 170:    */   {
/* 171:189 */     return new PresenceModelImpl(type, description);
/* 172:    */   }
/* 173:    */   
/* 174:    */   public PresenceModel createPresenceModel(PresenceActivityType type, String description, String note, String lang)
/* 175:    */   {
/* 176:194 */     return new PresenceModelImpl(type, description, note, lang);
/* 177:    */   }
/* 178:    */   
/* 179:    */   public native void setDebugMode(boolean paramBoolean, String paramString);
/* 180:    */   
/* 181:    */   private native void _setLogHandler(Object paramObject);
/* 182:    */   
/* 183:    */   public native void enableLogCollection(boolean paramBoolean);
/* 184:    */   
/* 185:    */   public native void setLogCollectionPath(String paramString);
/* 186:    */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.LinphoneCoreFactoryImpl

 * JD-Core Version:    0.7.0.1

 */