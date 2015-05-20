/*   1:    */ package org.linphone.core;
/*   2:    */ 
/*   3:    */ public class PresenceModelImpl
/*   4:    */   implements PresenceModel
/*   5:    */ {
/*   6:    */   private long mNativePtr;
/*   7:    */   
/*   8:    */   protected PresenceModelImpl(long nativePtr)
/*   9:    */   {
/*  10: 26 */     this.mNativePtr = nativePtr;
/*  11:    */   }
/*  12:    */   
/*  13:    */   private native long newPresenceModelImpl();
/*  14:    */   
/*  15:    */   protected PresenceModelImpl()
/*  16:    */   {
/*  17: 31 */     this.mNativePtr = newPresenceModelImpl();
/*  18:    */   }
/*  19:    */   
/*  20:    */   private native long newPresenceModelImpl(int paramInt, String paramString);
/*  21:    */   
/*  22:    */   protected PresenceModelImpl(PresenceActivityType type, String description)
/*  23:    */   {
/*  24: 36 */     this.mNativePtr = newPresenceModelImpl(type.toInt(), description);
/*  25:    */   }
/*  26:    */   
/*  27:    */   private native long newPresenceModelImpl(int paramInt, String paramString1, String paramString2, String paramString3);
/*  28:    */   
/*  29:    */   protected PresenceModelImpl(PresenceActivityType type, String description, String note, String lang)
/*  30:    */   {
/*  31: 41 */     this.mNativePtr = newPresenceModelImpl(type.toInt(), description, note, lang);
/*  32:    */   }
/*  33:    */   
/*  34:    */   private native void unref(long paramLong);
/*  35:    */   
/*  36:    */   protected void finalize()
/*  37:    */   {
/*  38: 46 */     unref(this.mNativePtr);
/*  39:    */   }
/*  40:    */   
/*  41:    */   private native int getBasicStatus(long paramLong);
/*  42:    */   
/*  43:    */   public PresenceBasicStatus getBasicStatus()
/*  44:    */   {
/*  45: 52 */     return PresenceBasicStatus.fromInt(getBasicStatus(this.mNativePtr));
/*  46:    */   }
/*  47:    */   
/*  48:    */   private native int setBasicStatus(long paramLong, int paramInt);
/*  49:    */   
/*  50:    */   public int setBasicStatus(PresenceBasicStatus basic_status)
/*  51:    */   {
/*  52: 58 */     return setBasicStatus(this.mNativePtr, basic_status.toInt());
/*  53:    */   }
/*  54:    */   
/*  55:    */   private native long getTimestamp(long paramLong);
/*  56:    */   
/*  57:    */   public long getTimestamp()
/*  58:    */   {
/*  59: 64 */     return getTimestamp(this.mNativePtr);
/*  60:    */   }
/*  61:    */   
/*  62:    */   private native String getContact(long paramLong);
/*  63:    */   
/*  64:    */   public String getContact()
/*  65:    */   {
/*  66: 70 */     return getContact(this.mNativePtr);
/*  67:    */   }
/*  68:    */   
/*  69:    */   private native void setContact(long paramLong, String paramString);
/*  70:    */   
/*  71:    */   public void setContact(String contact)
/*  72:    */   {
/*  73: 76 */     setContact(this.mNativePtr, contact);
/*  74:    */   }
/*  75:    */   
/*  76:    */   private native Object getActivity(long paramLong);
/*  77:    */   
/*  78:    */   public PresenceActivity getActivity()
/*  79:    */   {
/*  80: 82 */     return (PresenceActivity)getActivity(this.mNativePtr);
/*  81:    */   }
/*  82:    */   
/*  83:    */   private native int setActivity(long paramLong, int paramInt, String paramString);
/*  84:    */   
/*  85:    */   public int setActivity(PresenceActivityType activity, String description)
/*  86:    */   {
/*  87: 88 */     return setActivity(this.mNativePtr, activity.toInt(), description);
/*  88:    */   }
/*  89:    */   
/*  90:    */   private native long getNbActivities(long paramLong);
/*  91:    */   
/*  92:    */   public long getNbActivities()
/*  93:    */   {
/*  94: 94 */     return getNbActivities(this.mNativePtr);
/*  95:    */   }
/*  96:    */   
/*  97:    */   private native Object getNthActivity(long paramLong1, long paramLong2);
/*  98:    */   
/*  99:    */   public PresenceActivity getNthActivity(long idx)
/* 100:    */   {
/* 101:100 */     return (PresenceActivity)getNthActivity(this.mNativePtr, idx);
/* 102:    */   }
/* 103:    */   
/* 104:    */   private native int addActivity(long paramLong1, long paramLong2);
/* 105:    */   
/* 106:    */   public int addActivity(PresenceActivity activity)
/* 107:    */   {
/* 108:106 */     return addActivity(this.mNativePtr, activity.getNativePtr());
/* 109:    */   }
/* 110:    */   
/* 111:    */   private native int clearActivities(long paramLong);
/* 112:    */   
/* 113:    */   public int clearActivities()
/* 114:    */   {
/* 115:112 */     return clearActivities(this.mNativePtr);
/* 116:    */   }
/* 117:    */   
/* 118:    */   private native Object getNote(long paramLong, String paramString);
/* 119:    */   
/* 120:    */   public PresenceNote getNote(String lang)
/* 121:    */   {
/* 122:118 */     return (PresenceNote)getNote(this.mNativePtr, lang);
/* 123:    */   }
/* 124:    */   
/* 125:    */   private native int addNote(long paramLong, String paramString1, String paramString2);
/* 126:    */   
/* 127:    */   public int addNote(String note_content, String lang)
/* 128:    */   {
/* 129:124 */     return addNote(this.mNativePtr, note_content, lang);
/* 130:    */   }
/* 131:    */   
/* 132:    */   private native int clearNotes(long paramLong);
/* 133:    */   
/* 134:    */   public int clearNotes()
/* 135:    */   {
/* 136:130 */     return clearNotes(this.mNativePtr);
/* 137:    */   }
/* 138:    */   
/* 139:    */   private native long getNbServices(long paramLong);
/* 140:    */   
/* 141:    */   public long getNbServices()
/* 142:    */   {
/* 143:136 */     return getNbServices(this.mNativePtr);
/* 144:    */   }
/* 145:    */   
/* 146:    */   private native Object getNthService(long paramLong1, long paramLong2);
/* 147:    */   
/* 148:    */   public PresenceService getNthService(long idx)
/* 149:    */   {
/* 150:142 */     return (PresenceService)getNthService(this.mNativePtr, idx);
/* 151:    */   }
/* 152:    */   
/* 153:    */   private native int addService(long paramLong1, long paramLong2);
/* 154:    */   
/* 155:    */   public int addService(PresenceService service)
/* 156:    */   {
/* 157:148 */     return addService(this.mNativePtr, service.getNativePtr());
/* 158:    */   }
/* 159:    */   
/* 160:    */   private native int clearServices(long paramLong);
/* 161:    */   
/* 162:    */   public int clearServices()
/* 163:    */   {
/* 164:154 */     return clearServices(this.mNativePtr);
/* 165:    */   }
/* 166:    */   
/* 167:    */   private native long getNbPersons(long paramLong);
/* 168:    */   
/* 169:    */   public long getNbPersons()
/* 170:    */   {
/* 171:160 */     return getNbPersons(this.mNativePtr);
/* 172:    */   }
/* 173:    */   
/* 174:    */   private native Object getNthPerson(long paramLong1, long paramLong2);
/* 175:    */   
/* 176:    */   public PresencePerson getNthPerson(long idx)
/* 177:    */   {
/* 178:166 */     return (PresencePerson)getNthPerson(this.mNativePtr, idx);
/* 179:    */   }
/* 180:    */   
/* 181:    */   private native int addPerson(long paramLong1, long paramLong2);
/* 182:    */   
/* 183:    */   public int addPerson(PresencePerson person)
/* 184:    */   {
/* 185:172 */     return addPerson(this.mNativePtr, person.getNativePtr());
/* 186:    */   }
/* 187:    */   
/* 188:    */   private native int clearPersons(long paramLong);
/* 189:    */   
/* 190:    */   public int clearPersons()
/* 191:    */   {
/* 192:178 */     return clearPersons(this.mNativePtr);
/* 193:    */   }
/* 194:    */   
/* 195:    */   public long getNativePtr()
/* 196:    */   {
/* 197:182 */     return this.mNativePtr;
/* 198:    */   }
/* 199:    */ }


/* Location:           E:\DO-AN\Libraries\linphone-android-sdk-2.4.0\libs\LinLinphone\linphone.jar
 * Qualified Name:     org.linphone.core.PresenceModelImpl
 * JD-Core Version:    0.7.0.1
 */