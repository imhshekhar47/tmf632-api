package org.hshekhar.tmf632.apis

import org.hshekhar.tmf632.models.EventSubscription
import org.hshekhar.tmf632.models.EventSubscriptionInput
import org.springframework.stereotype.Service

/**
 * @created 10/22/2021'T'5:07 PM
 * @author Himanshu Shekhar (609080540)
 **/

@Service
class HubApiServiceImpl: HubApiService {
    override fun registerListener(data: EventSubscriptionInput): EventSubscription {
        TODO("Not yet implemented")
    }

    override fun unregisterListener(id: String) {
        TODO("Not yet implemented")
    }
}