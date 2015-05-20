/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ public class PresenceServiceImpl
/*   4:    */   implements PresenceService
/*   5:    */ {
/*   6:    */   private long mNativePtr;
/*   7:    */   
/*   8:    */   protected PresenceServiceImpl(long nativePtr)
/*   9:    */   {
/*  10: 26 */     this.mNativePtr = nativePtr;
/*  11:    */   }
/*  12:    */   
/*  13:    */   private native long newPresenceServiceImpl(String paramString1, int paramInt, String paramString2);
/*  14:    */   
/*  15:    */   protected PresenceServiceImpl(String id, PresenceBasicStatus status, String contact)
/*  16:    */   {
/*  17: 31 */     this.mNativePtr = newPresenceServiceImpl(id, status.toInt(), contact);
/*  18:    */   }
/*  19:    */   
/*  20:    */   private native void unref(long paramLong);
/*  21:    */   
/*  22:    */   protected void finalize()
/*  23:    */   {
/*  24: 36 */     unref(this.mNativePtr);
/*  25:    */   }
/*  26:    */   
/*  27:    */   private native String getId(long paramLong);
/*  28:    */   
/*  29:    */   public String getId()
/*  30:    */   {
/*  31: 42 */     return getId(this.mNativePtr);
/*  32:    */   }
/*  33:    */   
/*  34:    */   private native int setId(long paramLong, String paramString);
/*  35:    */   
/*  36:    */   public int setId(String id)
/*  37:    */   {
/*  38: 48 */     return setId(this.mNativePtr, id);
/*  39:    */   }
/*  40:    */   
/*  41:    */   private native int getBasicStatus(long paramLong);
/*  42:    */   
/*  43:    */   public PresenceBasicStatus getBasicStatus()
/*  44:    */   {
/*  45: 54 */     return PresenceBasicStatus.fromInt(getBasicStatus(this.mNativePtr));
/*  46:    */   }
/*  47:    */   
/*  48:    */   private native int setBasicStatus(long paramLong, int paramInt);
/*  49:    */   
/*  50:    */   public int setBasicStatus(PresenceBasicStatus status)
/*  51:    */   {
/*  52: 60 */     return setBasicStatus(this.mNativePtr, status.toInt());
/*  53:    */   }
/*  54:    */   
/*  55:    */   private native String getContact(long paramLong);
/*  56:    */   
/*  57:    */   public String getContact()
/*  58:    */   {
/*  59: 66 */     return getContact(this.mNativePtr);
/*  60:    */   }
/*  61:    */   
/*  62:    */   private native int setContact(long paramLong, String paramString);
/*  63:    */   
/*  64:    */   public int setContact(String contact)
/*  65:    */   {
/*  66: 72 */     return setContact(this.mNativePtr, contact);
/*  67:    */   }
/*  68:    */   
/*  69:    */   private native long getNbNotes(long paramLong);
/*  70:    */   
/*  71:    */   public long getNbNotes()
/*  72:    */   {
/*  73: 78 */     return getNbNotes(this.mNativePtr);
/*  74:    */   }
/*  75:    */   
/*  76:    */   private native Object getNthNote(long paramLong1, long paramLong2);
/*  77:    */   
/*  78:    */   public PresenceNote getNthNote(long idx)
/*  79:    */   {
/*  80: 84 */     return (PresenceNote)getNthNote(this.mNativePtr, idx);
/*  81:    */   }
/*  82:    */   
/*  83:    */   private native int addNote(long paramLong1, long paramLong2);
/*  84:    */   
/*  85:    */   public int addNote(PresenceNote note)
/*  86:    */   {
/*  87: 90 */     return addNote(this.mNativePtr, note.getNativePtr());
/*  88:    */   }
/*  89:    */   
/*  90:    */   private native int clearNotes(long paramLong);
/*  91:    */   
/*  92:    */   public int clearNotes()
/*  93:    */   {
/*  94: 96 */     return clearNotes(this.mNativePtr);
/*  95:    */   }
/*  96:    */   
/*  97:    */   public long getNativePtr()
/*  98:    */   {
/*  99:100 */     return this.mNativePtr;
/* 100:    */   }
/* 101:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PresenceServiceImpl
 * JD-Core Version:    0.7.0.1
 */