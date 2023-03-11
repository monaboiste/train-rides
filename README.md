# 🚆 Railway Connections Search Engine

🚧 Simple project to try out new approaches and technologies.

#### Rough drafts

```
BusLineRide - AggregateConsistencyBoundary / AggregateRoot
BusStatus busStatus

List<StopId> stopIds;

StopId currentStop;
StopId previousStopId;
StopId nextStopId;

// Behavoir
arriveAt(StopId stopId)
departFrom(StopId stopId)

isComplete()
```

Identifying entities and events for seat reservation.
```
--------------------    -----------------------------     -----------------
| Events           |    | Eventual Consistent Rules |     | Actions       |
| Ticket Requested |--> | Reservation Process       | --> | Reserve Seats |
--------------------    -----------------------------     -----------------
                                   ----------------------            |
                                   | Events             |            |
------------------------------     |--------------------|            v
| Eventual Consistent Rules  | <-- | Seats Reserved     |     ---------------------------------
| 15 minutes payment timeout |     |--------------------|     | Rules                         |
------------------------------     | No Seats Available | <-- | - one person per seat         |
         |                         |--------------------|     | - adjacent seats              |
         v                         | Enough Seats But   |     | - max 6 seats per reservation |
-----------------------            | No Adjacent Ones   |     ---------------------------------
| Events              |            ----------------------  
| Reservation Timeout |
-----------------------

```
