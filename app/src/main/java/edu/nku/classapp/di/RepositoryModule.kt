package edu.nku.classapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.nku.classapp.data.repository.AttackOnTitanRepository
import edu.nku.classapp.data.repository.AttackOnTitanRepositoryReal
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAttackOnTitanRepository(
        attackOnTitanRepositoryReal: AttackOnTitanRepositoryReal
    ) : AttackOnTitanRepository
}