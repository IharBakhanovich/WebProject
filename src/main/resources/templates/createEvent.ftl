<#import "_master.ftl" as master>
<@master.template>
    <h1>Create a new event</h1>
    <form method="post" action="/events/create"> <!--für das Schpeichern-->
        <label>Venue:</label>
        <input type="text" name="eventVenue"/>
        <h2>Event name</h2>
        <input type = "text" name="eventName">
        <button type="submit">Create</button>
    </form>
</@master.template>