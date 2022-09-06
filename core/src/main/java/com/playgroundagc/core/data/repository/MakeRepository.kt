package com.playgroundagc.core.data.repository

import com.playgroundagc.core.domain.model.Make

/**
 * Created by Amadou on 10/08/2022
 *
 */

class MakeRepository(private val dataSource: MakeDataSource) {
    fun toggleFavorite(make: Make): Make { return dataSource.favorite(make) }
}