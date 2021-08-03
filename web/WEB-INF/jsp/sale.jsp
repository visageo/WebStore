<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales Page</title>
    </head>
    <body>
        <h1><u>Sales Page</u></h1><br/><br/>
        <a href="/WebAssignment/item.htm">[Items]</a>
        <a href="/WebAssignment/customer.htm">[Customers]</a><br/><br/>

        <form:form action="sale.htm" method="post" commandName="sale">            

            <form:label path="itemId">Item ID</form:label><br/>
            <form:input id="itemId" type="int" path="itemId"></form:input><br/>
            <form:label path="customerId">Customer ID</form:label><br/>
            <form:input id="customerId" type="int" path="customerId"></form:input><br/><br/>

                <input type="submit" name="sell" value="Confirm Sale"/><br/><br/>

        </form:form>

        <label for="item_list" id="item_list_label">All items and Customers</label><br/> 
        <textarea id="item_list" rows="20" cols="50" readonly>${items}</textarea>       
        <textarea id="customer_list" rows="20" cols="50" readonly>${customers}</textarea>
    </body>
</html>
