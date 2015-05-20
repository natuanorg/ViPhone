/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ /*  4:   */
/*  5:   */ public abstract class LinphoneCoreFactory
/*  6:   */ {
/*  7:28 */   private static String factoryName = "org.linphone.core.LinphoneCoreFactoryImpl";
/*  8:   */   static LinphoneCoreFactory theLinphoneCoreFactory;
/*  9:   */   
/* 10:   */   public static void setFactoryClassName(String className)
/* 11:   */   {
/* 12:37 */     factoryName = className;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public static final synchronized LinphoneCoreFactory instance()
/* 16:   */   {
/* 17:   */     try
/* 18:   */     {
/* 19:43 */       if (theLinphoneCoreFactory == null)
/* 20:   */       {
/* 21:44 */         Class<?> lFactoryClass = Class.forName(factoryName);
/* 22:45 */         theLinphoneCoreFactory = (LinphoneCoreFactory)lFactoryClass.newInstance();
/* 23:   */       }
/* 24:   */     }
/* 25:   */     catch (Exception e)
/* 26:   */     {
/* 27:48 */       System.err.println("Cannot instanciate factory [" + factoryName + "]");
/* 28:   */     }
/* 29:50 */     return theLinphoneCoreFactory;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public abstract LinphoneAuthInfo createAuthInfo(String paramString1, String paramString2, String paramString3, String paramString4);
/* 33:   */   
/* 34:   */   public abstract LinphoneAuthInfo createAuthInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
/* 35:   */   
/* 36:   */   public abstract LinphoneCore createLinphoneCore(LinphoneCoreListener paramLinphoneCoreListener, String paramString1, String paramString2, Object paramObject1, Object paramObject2)
/* 37:   */     throws LinphoneCoreException;
/* 38:   */   
/* 39:   */   public abstract LinphoneCore createLinphoneCore(LinphoneCoreListener paramLinphoneCoreListener, Object paramObject)
/* 40:   */     throws LinphoneCoreException;
/* 41:   */   
/* 42:   */   public abstract LinphoneAddress createLinphoneAddress(String paramString1, String paramString2, String paramString3);
/* 43:   */   
/* 44:   */   public abstract LinphoneAddress createLinphoneAddress(String paramString)
/* 45:   */     throws LinphoneCoreException;
/* 46:   */   
/* 47:   */   public abstract LpConfig createLpConfig(String paramString);
/* 48:   */   
/* 49:   */   public abstract void setDebugMode(boolean paramBoolean, String paramString);
/* 50:   */   
/* 51:   */   public abstract void enableLogCollection(boolean paramBoolean);
/* 52:   */   
/* 53:   */   public abstract void setLogCollectionPath(String paramString);
/* 54:   */   
/* 55:   */   public abstract void setLogHandler(LinphoneLogHandler paramLinphoneLogHandler);
/* 56:   */   
/* 57:   */   public abstract LinphoneFriend createLinphoneFriend(String paramString);
/* 58:   */   
/* 59:   */   public abstract LinphoneFriend createLinphoneFriend();
/* 60:   */   
/* 61:   */   public abstract LinphoneContent createLinphoneContent(String paramString1, String paramString2, String paramString3);
/* 62:   */   
/* 63:   */   public abstract LinphoneContent createLinphoneContent(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3);
/* 64:   */   
/* 65:   */   public abstract PresenceActivity createPresenceActivity(PresenceActivityType paramPresenceActivityType, String paramString);
/* 66:   */   
/* 67:   */   public abstract PresenceService createPresenceService(String paramString1, PresenceBasicStatus paramPresenceBasicStatus, String paramString2);
/* 68:   */   
/* 69:   */   public abstract PresenceModel createPresenceModel();
/* 70:   */   
/* 71:   */   public abstract PresenceModel createPresenceModel(PresenceActivityType paramPresenceActivityType, String paramString);
/* 72:   */   
/* 73:   */   public abstract PresenceModel createPresenceModel(PresenceActivityType paramPresenceActivityType, String paramString1, String paramString2, String paramString3);
/* 74:   */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.LinphoneCoreFactory

 * JD-Core Version:    0.7.0.1

 */