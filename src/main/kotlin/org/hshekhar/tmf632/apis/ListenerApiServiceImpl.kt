package org.hshekhar.tmf632.apis

import org.hshekhar.tmf632.models.*
import org.springframework.stereotype.Service

/**
 * @created 10/22/2021'T'5:08 PM
 * @author Himanshu Shekhar (609080540)
 **/

@Service
class ListenerApiServiceImpl: ListenerApiService {
    override fun listenToIndividualAttributeValueChangeEvent(data: IndividualAttributeValueChangeEvent): EventSubscription {
        TODO("Not yet implemented")
    }

    override fun listenToIndividualCreateEvent(data: IndividualCreateEvent): EventSubscription {
        TODO("Not yet implemented")
    }

    override fun listenToIndividualDeleteEvent(data: IndividualDeleteEvent): EventSubscription {
        TODO("Not yet implemented")
    }

    override fun listenToIndividualStateChangeEvent(data: IndividualStateChangeEvent): EventSubscription {
        TODO("Not yet implemented")
    }

    override fun listenToOrganizationAttributeValueChangeEvent(data: OrganizationAttributeValueChangeEvent): EventSubscription {
        TODO("Not yet implemented")
    }

    override fun listenToOrganizationCreateEvent(data: OrganizationCreateEvent): EventSubscription {
        TODO("Not yet implemented")
    }

    override fun listenToOrganizationDeleteEvent(data: OrganizationDeleteEvent): EventSubscription {
        TODO("Not yet implemented")
    }

    override fun listenToOrganizationStateChangeEvent(data: OrganizationStateChangeEvent): EventSubscription {
        TODO("Not yet implemented")
    }
}