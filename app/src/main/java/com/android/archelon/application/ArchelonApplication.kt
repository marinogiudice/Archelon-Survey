package com.android.archelon.application

import android.app.Application
import com.android.archelon.database.ArchelonDb
import com.android.archelon.repository.ArchelonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ArchelonApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val archelonDB by lazy { ArchelonDb.getInstance(this, applicationScope)}
    val archelonRepo by lazy { ArchelonRepository(archelonDB.archelonDbDao()) }
}