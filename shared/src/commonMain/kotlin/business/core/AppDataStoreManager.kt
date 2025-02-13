package business.core

import common.Context
import common.getData
import common.putData

const val APP_DATASTORE = "co.jp.omooooori.yarutan"

class AppDataStoreManager(val context: Context) : AppDataStore {
    override suspend fun setValue(
        key: String,
        value: String,
    ) {
        context.putData(key, value)
    }

    override suspend fun readValue(key: String): String? {
        return context.getData(key)
    }
}
