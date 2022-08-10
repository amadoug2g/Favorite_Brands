package com.playgroundagc.core.domain.usecases

import com.playgroundagc.core.data.repository.MakeRepository
import com.playgroundagc.core.domain.model.Make

/**
 * Created by Amadou on 10/08/2022
 *
 */

class ToggleFavoriteUC(private val repository: MakeRepository) {
    operator fun invoke(make: Make) = repository.toggleFavorite(make)
}