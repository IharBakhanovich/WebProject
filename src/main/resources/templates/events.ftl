<#import "_master.ftl" as master>
<@master.template>
<div>
    <ol>
        <#list events as event>
            <li>
                <#if event??>
                <a href="/event/${event.id}">
                    <strong>${event.venue}</strong>
                    </a>
                <#else>
                    <a href="/events/create">Create a new event</a>
                </#if>
            </li>
        </#list>
    </ol>
</div>
    <a href="/events/create">Create a new event</a>
</@master.template>