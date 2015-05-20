/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ class LpConfigImpl
/*   4:    */   implements LpConfig
/*   5:    */ {
/*   6:    */   private final long nativePtr;
/*   7: 26 */   boolean ownPtr = false;
/*   8:    */   
/*   9:    */   public LpConfigImpl(long ptr)
/*  10:    */   {
/*  11: 29 */     this.nativePtr = ptr;
/*  12:    */   }
/*  13:    */   
/*  14:    */   private native long newLpConfigImpl(String paramString);
/*  15:    */   
/*  16:    */   private native void delete(long paramLong);
/*  17:    */   
/*  18:    */   public LpConfigImpl(String file)
/*  19:    */   {
/*  20: 36 */     this.nativePtr = newLpConfigImpl(file);
/*  21: 37 */     this.ownPtr = true;
/*  22:    */   }
/*  23:    */   
/*  24:    */   protected void finalize()
/*  25:    */     throws Throwable
/*  26:    */   {
/*  27: 41 */     if (this.ownPtr) {
/*  28: 42 */       delete(this.nativePtr);
/*  29:    */     }
/*  30:    */   }
/*  31:    */   
/*  32:    */   private native void sync(long paramLong);
/*  33:    */   
/*  34:    */   public void sync()
/*  35:    */   {
/*  36: 49 */     sync(this.nativePtr);
/*  37:    */   }
/*  38:    */   
/*  39:    */   private native void setInt(long paramLong, String paramString1, String paramString2, int paramInt);
/*  40:    */   
/*  41:    */   public void setInt(String section, String key, int value)
/*  42:    */   {
/*  43: 55 */     setInt(this.nativePtr, section, key, value);
/*  44:    */   }
/*  45:    */   
/*  46:    */   private native void setFloat(long paramLong, String paramString1, String paramString2, float paramFloat);
/*  47:    */   
/*  48:    */   public void setFloat(String section, String key, float value)
/*  49:    */   {
/*  50: 61 */     setFloat(this.nativePtr, section, key, value);
/*  51:    */   }
/*  52:    */   
/*  53:    */   private native void setBool(long paramLong, String paramString1, String paramString2, boolean paramBoolean);
/*  54:    */   
/*  55:    */   public void setBool(String section, String key, boolean value)
/*  56:    */   {
/*  57: 67 */     setBool(this.nativePtr, section, key, value);
/*  58:    */   }
/*  59:    */   
/*  60:    */   private native void setString(long paramLong, String paramString1, String paramString2, String paramString3);
/*  61:    */   
/*  62:    */   public void setString(String section, String key, String value)
/*  63:    */   {
/*  64: 73 */     setString(this.nativePtr, section, key, value);
/*  65:    */   }
/*  66:    */   
/*  67:    */   private native void setIntRange(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2);
/*  68:    */   
/*  69:    */   public void setIntRange(String section, String key, int min, int max)
/*  70:    */   {
/*  71: 79 */     setIntRange(this.nativePtr, section, key, min, max);
/*  72:    */   }
/*  73:    */   
/*  74:    */   private native int getInt(long paramLong, String paramString1, String paramString2, int paramInt);
/*  75:    */   
/*  76:    */   public int getInt(String section, String key, int defaultValue)
/*  77:    */   {
/*  78: 85 */     return getInt(this.nativePtr, section, key, defaultValue);
/*  79:    */   }
/*  80:    */   
/*  81:    */   private native float getFloat(long paramLong, String paramString1, String paramString2, float paramFloat);
/*  82:    */   
/*  83:    */   public float getFloat(String section, String key, float defaultValue)
/*  84:    */   {
/*  85: 91 */     return getFloat(this.nativePtr, section, key, defaultValue);
/*  86:    */   }
/*  87:    */   
/*  88:    */   private native boolean getBool(long paramLong, String paramString1, String paramString2, boolean paramBoolean);
/*  89:    */   
/*  90:    */   public boolean getBool(String section, String key, boolean defaultValue)
/*  91:    */   {
/*  92: 97 */     return getBool(this.nativePtr, section, key, defaultValue);
/*  93:    */   }
/*  94:    */   
/*  95:    */   private native String getString(long paramLong, String paramString1, String paramString2, String paramString3);
/*  96:    */   
/*  97:    */   public String getString(String section, String key, String defaultValue)
/*  98:    */   {
/*  99:103 */     return getString(this.nativePtr, section, key, defaultValue);
/* 100:    */   }
/* 101:    */   
/* 102:    */   private native int[] getIntRange(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2);
/* 103:    */   
/* 104:    */   public int[] getIntRange(String section, String key, int defaultMin, int defaultMax)
/* 105:    */   {
/* 106:109 */     return getIntRange(this.nativePtr, section, key, defaultMin, defaultMax);
/* 107:    */   }
/* 108:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.LpConfigImpl
 * JD-Core Version:    0.7.0.1
 */