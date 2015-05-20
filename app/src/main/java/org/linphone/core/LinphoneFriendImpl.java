/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ 
/*   5:    */ class LinphoneFriendImpl
/*   6:    */   implements LinphoneFriend, Serializable
/*   7:    */ {
/*   8:    */   protected final long nativePtr;
/*   9:    */   
/*  10:    */   private native void finalize(long paramLong);
/*  11:    */   
/*  12:    */   private native long newLinphoneFriend(String paramString);
/*  13:    */   
/*  14:    */   private native void setAddress(long paramLong1, long paramLong2);
/*  15:    */   
/*  16:    */   private native long getAddress(long paramLong);
/*  17:    */   
/*  18:    */   private native void setIncSubscribePolicy(long paramLong, int paramInt);
/*  19:    */   
/*  20:    */   private native int getIncSubscribePolicy(long paramLong);
/*  21:    */   
/*  22:    */   private native void enableSubscribes(long paramLong, boolean paramBoolean);
/*  23:    */   
/*  24:    */   private native boolean isSubscribesEnabled(long paramLong);
/*  25:    */   
/*  26:    */   private native int getStatus(long paramLong);
/*  27:    */   
/*  28:    */   private native Object getPresenceModel(long paramLong);
/*  29:    */   
/*  30:    */   private native void setPresenceModel(long paramLong1, long paramLong2);
/*  31:    */   
/*  32:    */   private native void edit(long paramLong);
/*  33:    */   
/*  34:    */   private native void done(long paramLong);
/*  35:    */   
/*  36:    */   private native Object getCore(long paramLong);
/*  37:    */   
/*  38:    */   private native void setRefKey(long paramLong, String paramString);
/*  39:    */   
/*  40:    */   private native String getRefKey(long paramLong);
/*  41:    */   
/*  42:    */   protected LinphoneFriendImpl()
/*  43:    */   {
/*  44: 43 */     this.nativePtr = newLinphoneFriend(null);
/*  45:    */   }
/*  46:    */   
/*  47:    */   protected LinphoneFriendImpl(String friendUri)
/*  48:    */   {
/*  49: 46 */     this.nativePtr = newLinphoneFriend(friendUri);
/*  50:    */   }
/*  51:    */   
/*  52:    */   protected LinphoneFriendImpl(long aNativePtr)
/*  53:    */   {
/*  54: 51 */     this.nativePtr = aNativePtr;
/*  55:    */   }
/*  56:    */   
/*  57:    */   protected void finalize()
/*  58:    */     throws Throwable
/*  59:    */   {
/*  60: 54 */     if (this.nativePtr != 0L) {
/*  61: 55 */       finalize(this.nativePtr);
/*  62:    */     }
/*  63: 57 */     super.finalize();
/*  64:    */   }
/*  65:    */   
/*  66:    */   public void setAddress(LinphoneAddress anAddress)
/*  67:    */   {
/*  68: 60 */     setAddress(this.nativePtr, ((LinphoneAddressImpl)anAddress).nativePtr);
/*  69:    */   }
/*  70:    */   
/*  71:    */   public LinphoneAddress getAddress()
/*  72:    */   {
/*  73: 63 */     return new LinphoneAddressImpl(getAddress(this.nativePtr), LinphoneAddressImpl.WrapMode.FromConst);
/*  74:    */   }
/*  75:    */   
/*  76:    */   public void setIncSubscribePolicy(SubscribePolicy policy)
/*  77:    */   {
/*  78: 66 */     synchronized (getSyncObject())
/*  79:    */     {
/*  80: 67 */       setIncSubscribePolicy(this.nativePtr, policy.mValue);
/*  81:    */     }
/*  82:    */   }
/*  83:    */   
/*  84:    */   public SubscribePolicy getIncSubscribePolicy()
/*  85:    */   {
/*  86: 71 */     return SubscribePolicy.fromInt(getIncSubscribePolicy(this.nativePtr));
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void enableSubscribes(boolean enable)
/*  90:    */   {
/*  91: 74 */     synchronized (getSyncObject())
/*  92:    */     {
/*  93: 75 */       enableSubscribes(this.nativePtr, enable);
/*  94:    */     }
/*  95:    */   }
/*  96:    */   
/*  97:    */   public boolean isSubscribesEnabled()
/*  98:    */   {
/*  99: 79 */     return isSubscribesEnabled(this.nativePtr);
/* 100:    */   }
/* 101:    */   
/* 102:    */   public OnlineStatus getStatus()
/* 103:    */   {
/* 104: 82 */     return OnlineStatus.fromInt(getStatus(this.nativePtr));
/* 105:    */   }
/* 106:    */   
/* 107:    */   public PresenceModel getPresenceModel()
/* 108:    */   {
/* 109: 85 */     return (PresenceModel)getPresenceModel(this.nativePtr);
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void edit()
/* 113:    */   {
/* 114: 88 */     synchronized (getSyncObject())
/* 115:    */     {
/* 116: 89 */       edit(this.nativePtr);
/* 117:    */     }
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void done()
/* 121:    */   {
/* 122: 93 */     synchronized (getSyncObject())
/* 123:    */     {
/* 124: 94 */       done(this.nativePtr);
/* 125:    */     }
/* 126:    */   }
/* 127:    */   
/* 128:    */   public long getNativePtr()
/* 129:    */   {
/* 130: 98 */     return this.nativePtr;
/* 131:    */   }
/* 132:    */   
/* 133:    */   private Object getSyncObject()
/* 134:    */   {
/* 135:107 */     Object core = getCore(this.nativePtr);
/* 136:108 */     if (core != null) {
/* 137:108 */       return core;
/* 138:    */     }
/* 139:109 */     return this;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setRefKey(String key)
/* 143:    */   {
/* 144:113 */     synchronized (getSyncObject())
/* 145:    */     {
/* 146:114 */       setRefKey(this.nativePtr, key);
/* 147:    */     }
/* 148:    */   }
/* 149:    */   
/* 150:    */   public String getRefKey()
/* 151:    */   {
/* 152:119 */     return getRefKey(this.nativePtr);
/* 153:    */   }
/* 154:    */ }



/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar

 * Qualified Name:     org.linphone.core.LinphoneFriendImpl

 * JD-Core Version:    0.7.0.1

 */