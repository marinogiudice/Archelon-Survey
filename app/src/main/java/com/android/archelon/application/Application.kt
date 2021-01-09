package com.bignerdranch.android.login.Application

import android.app.Application
import com.bignerdranch.android.login.database.ArchelonDb
import com.bignerdranch.android.login.repository.ArchelonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ArchelonApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val archelonDB by lazy { ArchelonDb.getInstance(this, applicationScope)}
    val archelonRepo by lazy { ArchelonRepository(archelonDB.archelonDbDao()) }
}