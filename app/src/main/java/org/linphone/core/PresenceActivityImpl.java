/*  1:   */ package org.linphone.core;
/*  2:   */ 
/*  3:   */ public class PresenceActivityImpl
/*  4:   */   implements PresenceActivity
/*  5:   */ {
/*  6:   */   private long mNativePtr;
/*  7:   */   
/*  8:   */   protected PresenceActivityImpl(long nativePtr)
/*  9:   */   {
/* 10:26 */     this.mNativePtr = nativePtr;
/* 11:   */   }
/* 12:   */   
/* 13:   */   private native long newPresenceActivityImpl(int paramInt, String paramString);
/* 14:   */   
/* 15:   */   protected PresenceActivityImpl(PresenceActivityType type, String description)
/* 16:   */   {
/* 17:31 */     this.mNativePtr = newPresenceActivityImpl(type.toInt(), description);
/* 18:   */   }
/* 19:   */   
/* 20:   */   private native void unref(long paramLong);
/* 21:   */   
/* 22:   */   protected void finalize()
/* 23:   */   {
/* 24:36 */     unref(this.mNativePtr);
/* 25:   */   }
/* 26:   */   
/* 27:   */   private native String toString(long paramLong);
/* 28:   */   
/* 29:   */   public String toString()
/* 30:   */   {
/* 31:42 */     return toString(this.mNativePtr);
/* 32:   */   }
/* 33:   */   
/* 34:   */   private native int getType(long paramLong);
/* 35:   */   
/* 36:   */   public PresenceActivityType getType()
/* 37:   */   {
/* 38:48 */     return PresenceActivityType.fromInt(getType(this.mNativePtr));
/* 39:   */   }
/* 40:   */   
/* 41:   */   private native int setType(long paramLong, int paramInt);
/* 42:   */   
/* 43:   */   public int setType(PresenceActivityType type)
/* 44:   */   {
/* 45:54 */     return setType(this.mNativePtr, type.toInt());
/* 46:   */   }
/* 47:   */   
/* 48:   */   private native String getDescription(long paramLong);
/* 49:   */   
/* 50:   */   public String getDescription()
/* 51:   */   {
/* 52:60 */     return getDescription(this.mNativePtr);
/* 53:   */   }
/* 54:   */   
/* 55:   */   private native int setDescription(long paramLong, String paramString);
/* 56:   */   
/* 57:   */   public int setDescription(String description)
/* 58:   */   {
/* 59:66 */     return setDescription(this.mNativePtr, description);
/* 60:   */   }
/* 61:   */   
/* 62:   */   public long getNativePtr()
/* 63:   */   {
/* 64:70 */     return this.mNativePtr;
/* 65:   */   }
/* 66:   */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PresenceActivityImpl
 * JD-Core Version:    0.7.0.1
 */