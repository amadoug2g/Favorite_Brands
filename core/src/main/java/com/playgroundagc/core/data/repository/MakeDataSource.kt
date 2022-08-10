package com.playgroundagc.core.data.repository

import com.playgroundagc.core.domain.model.Make

/**
 * Created by Amadou on 10/08/2022
 *
 */

interface MakeDataSource {
    fun favorite(make: Make)
}