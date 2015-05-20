/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ class LinphoneAuthInfoImpl
/*   4:    */   implements LinphoneAuthInfo
/*   5:    */ {
/*   6:    */   protected final long nativePtr;
/*   7: 38 */   boolean ownPtr = false;
/*   8:    */   
/*   9:    */   private native long newLinphoneAuthInfo();
/*  10:    */   
/*  11:    */   private native void delete(long paramLong);
/*  12:    */   
/*  13:    */   private native String getPassword(long paramLong);
/*  14:    */   
/*  15:    */   private native String getRealm(long paramLong);
/*  16:    */   
/*  17:    */   private native String getUsername(long paramLong);
/*  18:    */   
/*  19:    */   private native void setPassword(long paramLong, String paramString);
/*  20:    */   
/*  21:    */   private native void setRealm(long paramLong, String paramString);
/*  22:    */   
/*  23:    */   private native void setUsername(long paramLong, String paramString);
/*  24:    */   
/*  25:    */   private native void setUserId(long paramLong, String paramString);
/*  26:    */   
/*  27:    */   private native void setHa1(long paramLong, String paramString);
/*  28:    */   
/*  29:    */   private native String getUserId(long paramLong);
/*  30:    */   
/*  31:    */   private native String getHa1(long paramLong);
/*  32:    */   
/*  33:    */   private native String getDomain(long paramLong);
/*  34:    */   
/*  35:    */   private native void setDomain(long paramLong, String paramString);
/*  36:    */   
/*  37:    */   protected LinphoneAuthInfoImpl(String username, String password, String realm, String domain)
/*  38:    */   {
/*  39: 40 */     this(username, null, password, null, realm, domain);
/*  40:    */   }
/*  41:    */   
/*  42:    */   protected LinphoneAuthInfoImpl(String username, String userid, String passwd, String ha1, String realm, String domain)
/*  43:    */   {
/*  44: 43 */     this.nativePtr = newLinphoneAuthInfo();
/*  45: 44 */     setUsername(username);
/*  46: 45 */     setUserId(userid);
/*  47: 46 */     setPassword(passwd);
/*  48: 47 */     setHa1(ha1);
/*  49: 48 */     setDomain(domain);
/*  50: 49 */     setRealm(realm);
/*  51: 50 */     this.ownPtr = true;
/*  52:    */   }
/*  53:    */   
/*  54:    */   protected LinphoneAuthInfoImpl(long aNativePtr)
/*  55:    */   {
/*  56: 53 */     this.nativePtr = aNativePtr;
/*  57: 54 */     this.ownPtr = false;
/*  58:    */   }
/*  59:    */   
/*  60:    */   protected void finalize()
/*  61:    */     throws Throwable
/*  62:    */   {
/*  63: 57 */     if (this.ownPtr) {
/*  64: 57 */       delete(this.nativePtr);
/*  65:    */     }
/*  66:    */   }
/*  67:    */   
/*  68:    */   public String getPassword()
/*  69:    */   {
/*  70: 60 */     return getPassword(this.nativePtr);
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getRealm()
/*  74:    */   {
/*  75: 63 */     return getRealm(this.nativePtr);
/*  76:    */   }
/*  77:    */   
/*  78:    */   public String getUsername()
/*  79:    */   {
/*  80: 66 */     return getUsername(this.nativePtr);
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setPassword(String password)
/*  84:    */   {
/*  85: 69 */     setPassword(this.nativePtr, password);
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setRealm(String realm)
/*  89:    */   {
/*  90: 72 */     setRealm(this.nativePtr, realm);
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setUsername(String username)
/*  94:    */   {
/*  95: 75 */     setUsername(this.nativePtr, username);
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getUserId()
/*  99:    */   {
/* 100: 79 */     return getUserId(this.nativePtr);
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setUserId(String userid)
/* 104:    */   {
/* 105: 83 */     setUserId(this.nativePtr, userid);
/* 106:    */   }
/* 107:    */   
/* 108:    */   public String getHa1()
/* 109:    */   {
/* 110: 88 */     return getHa1(this.nativePtr);
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setHa1(String ha1)
/* 114:    */   {
/* 115: 92 */     setHa1(this.nativePtr, ha1);
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setDomain(String domain)
/* 119:    */   {
/* 120: 97 */     setDomain(this.nativePtr, domain);
/* 121:    */   }
/* 122:    */   
/* 123:    */   public String getDomain()
/* 124:    */   {
/* 125:101 */     return getDomain(this.nativePtr);
/* 126:    */   }
/* 127:    */   
/* 128:    */   public LinphoneAuthInfo clone()
/* 129:    */   {
/* 130:105 */     LinphoneAuthInfo clone = LinphoneCoreFactory.instance().createAuthInfo(getUsername(), getUserId(), getPassword(), getHa1(), getRealm(), getDomain());
/* 131:    */     
/* 132:    */ 
/* 133:    */ 
/* 134:    */ 
/* 135:    */ 
/* 136:    */ 
/* 137:112 */     return clone;
/* 138:    */   }
/* 139:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LinphoneAuthInfoImpl
 * JD-Core Version:    0.7.0.1
 */