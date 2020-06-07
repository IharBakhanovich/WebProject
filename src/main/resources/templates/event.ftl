<#import "_master.ftl" as master>
<@master.template>
<h1>${event.id}</h1><!--nehmen das Event aus und zeigen auf den Nummer-->
<p>Venue: ${event.venue}</p> <!-- auch für das Attribut 'venue'-->
    <!-- füg ein paar Eigenschaften hinzu-->
    <a href="/events">Back to events</a>
<!--<p> Date of event: ${event.date.toString()}</p> fehler-->
</@master.template>