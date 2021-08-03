<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Items Page</title>
    </head>
    <body>
        <h1><u>Items Page</u></h1><br/>
        <a href="/WebAssignment/item.htm">[Items]</a> 
        <a href="/WebAssignment/customer.htm">[Customers]</a><br/><br/>

        <form:form action="item.htm" method="post" commandName="item">            

            <form:label path="id">Item ID</form:label><br/>
            <form:input id="id" type="int" path="id" placeholder="Only use to edit/delete"></form:input><br/>
            <form:label path="name">Item name:</form:label><br/>
            <form:input id="name" type="text" path="name" placeholder="Example: Shoes"></form:input><br/>
            <form:label path="price">Item price:</form:label ><br/>
            <form:input id="price" path="price"></form:input><br/>
            <form:label path="amount">Units available:</form:label ><br/>
            <form:input id="amount" path="amount"></form:input><br/><br/>

                <input type="submit" name="add" value="Add item"/>
                <input type="submit" name="delete" value="Delete on ID"/>
                <input type="submit" name="edit" value="Edit on ID"/><br/><br/>

        </form:form>

        <label for="item_list" id="item_list_label">All items</label><br/>
        <textarea id="item_list" rows="20" cols="50" readonly>${items}</textarea>
    </body>
</html>