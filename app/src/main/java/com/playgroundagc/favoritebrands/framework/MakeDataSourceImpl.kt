package com.playgroundagc.favoritebrands.framework

import com.playgroundagc.core.data.repository.MakeDataSource
import com.playgroundagc.core.domain.model.Make

/**
 * Created by Amadou on 11/08/2022
 *
 */

class MakeDataSourceImpl: MakeDataSource {
    override fun favorite(make: Make) {
        make.isFavorite = !make.isFavorite
    }
}