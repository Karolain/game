<%@ tag description="Formatted required for" pageEncoding="UTF-8" %>
<%@attribute name="currentCharacter" type="beans.GameCharacter" required="true" %>

<table class="player-details">
    <tr>
        <td class="h">Name</td><td>${currentCharacter.name}</td>
        <td class="h">Race</td><td>${currentCharacter.race}</td>
    </tr>
    <tr>
        <td class="h">Might</td>
        <td class="h">Endurance</td>
        <td class="h">Finesse</td>
        <td class="h">Charm</td>
        <td class="h">Mind</td>
        <td class="h">Spirit</td>
        <td class="h">Gold</td>
    </tr>
    <tr>
        <td>${currentCharacter.might}</td>
        <td>${currentCharacter.endurance}</td>
        <td>${currentCharacter.finesse}</td>
        <td>${currentCharacter.charm}</td>
        <td>${currentCharacter.mind}</td>
        <td>${currentCharacter.spirit}</td>
        <td>${currentCharacter.gold}</td>
    </tr>
</table>