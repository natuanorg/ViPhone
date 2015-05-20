/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ public class PresencePersonImpl
/*   4:    */   implements PresencePerson
/*   5:    */ {
/*   6:    */   private long mNativePtr;
/*   7:    */   
/*   8:    */   protected PresencePersonImpl(long nativePtr)
/*   9:    */   {
/*  10: 26 */     this.mNativePtr = nativePtr;
/*  11:    */   }
/*  12:    */   
/*  13:    */   private native long newPresencePersonImpl(String paramString);
/*  14:    */   
/*  15:    */   protected PresencePersonImpl(String id)
/*  16:    */   {
/*  17: 31 */     this.mNativePtr = newPresencePersonImpl(id);
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
/*  41:    */   private native long getNbActivities(long paramLong);
/*  42:    */   
/*  43:    */   public long getNbActivities()
/*  44:    */   {
/*  45: 54 */     return getNbActivities(this.mNativePtr);
/*  46:    */   }
/*  47:    */   
/*  48:    */   private native Object getNthActivity(long paramLong1, long paramLong2);
/*  49:    */   
/*  50:    */   public PresenceActivity getNthActivity(long idx)
/*  51:    */   {
/*  52: 60 */     return (PresenceActivity)getNthActivity(this.mNativePtr, idx);
/*  53:    */   }
/*  54:    */   
/*  55:    */   private native int addActivity(long paramLong1, long paramLong2);
/*  56:    */   
/*  57:    */   public int addActivity(PresenceActivity activity)
/*  58:    */   {
/*  59: 66 */     return addActivity(this.mNativePtr, activity.getNativePtr());
/*  60:    */   }
/*  61:    */   
/*  62:    */   private native int clearActivities(long paramLong);
/*  63:    */   
/*  64:    */   public int clearActivities()
/*  65:    */   {
/*  66: 72 */     return clearActivities(this.mNativePtr);
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
/*  97:    */   private native long getNbActivitiesNotes(long paramLong);
/*  98:    */   
/*  99:    */   public long getNbActivitiesNotes()
/* 100:    */   {
/* 101:102 */     return getNbActivitiesNotes(this.mNativePtr);
/* 102:    */   }
/* 103:    */   
/* 104:    */   private native Object getNthActivitiesNote(long paramLong1, long paramLong2);
/* 105:    */   
/* 106:    */   public PresenceNote getNthActivitiesNote(long idx)
/* 107:    */   {
/* 108:108 */     return (PresenceNote)getNthActivitiesNote(this.mNativePtr, idx);
/* 109:    */   }
/* 110:    */   
/* 111:    */   private native int addActivitiesNote(long paramLong1, long paramLong2);
/* 112:    */   
/* 113:    */   public int addActivitiesNote(PresenceNote note)
/* 114:    */   {
/* 115:114 */     return addActivitiesNote(this.mNativePtr, note.getNativePtr());
/* 116:    */   }
/* 117:    */   
/* 118:    */   private native int clearActivitesNotes(long paramLong);
/* 119:    */   
/* 120:    */   public int clearActivitesNotes()
/* 121:    */   {
/* 122:120 */     return clearActivitesNotes(this.mNativePtr);
/* 123:    */   }
/* 124:    */   
/* 125:    */   public long getNativePtr()
/* 126:    */   {
/* 127:124 */     return this.mNativePtr;
/* 128:    */   }
/* 129:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PresencePersonImpl
 * JD-Core Version:    0.7.0.1
 */