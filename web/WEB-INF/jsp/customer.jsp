<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers Page</title>
    </head>
    <body>

        <h1><u>Customers Page</u></h1><br/>
        <a href="/WebAssignment/item.htm">[Items]</a> 
        <a href="/WebAssignment/sale.htm">[Sales]</a><br/><br/>

        <form:form action="customer.htm" method="post" commandName="customer">

            <form:label path="id">Customer ID</form:label><br/>
            <form:input id="id" type="int" path="id" placeholder="Only use to edit/delete"></form:input><br/>
            <form:label path="name">Username:</form:label><br/>
            <form:input id="name" type="text" path="name"></form:input><br/>
            <form:label path="balance">Funds available:</form:label ><br/>
            <form:input id="balance" path="balance"></form:input><br/><br/>

                <input type="submit" name="add" value="Add customer"/>
                <input type="submit" name="delete" value="Delete on ID"/>
                <input type="submit" name="edit" value="Edit on ID"/><br/><br/>

        </form:form>

        <label for="customer_list" id="customer_list_label">All customers</label><br/>
        <textarea id="customer_list" rows="20" cols="50" readonly>${customers}</textarea>
    </body>
</html>