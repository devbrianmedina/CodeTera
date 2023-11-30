package com.dercide.codetera.models

import android.provider.BaseColumns

class CourseContract {
    companion object {
        class Entry: BaseColumns {
            companion object {
                val TABLE_NAME = "course"
                val COLUMN_ID = "id_course"
                val COLUMN_NAME = "name"
                val COLUMN_BRIEF_DESCRIPTION = "brief_description"
                val COLUMN_DESCRIPTION = "description"
                val COLUMN_TOPICS = "topics"
                val COLUMN_PRICE = "price"
                val COLUMN_QUALIFICATION = "qualification"
                val COLUMN_CREATOR = "creator"
                val COLUMN_CREATOR_JOB = "creator_job"
                val COLUMN_COMENTARIOS = "comments"
            }
        }
    }
}