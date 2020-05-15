package ru.kemsu.openenv.model

import java.io.Serializable

data class Support(private var username: String,
                   private var title: String,
                   private var text: String
) : BaseEntity(), Serializable


