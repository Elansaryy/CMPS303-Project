package HashTables;

import stack_queue.LinkedStack;

import java.io.Serializable;

public class StackTable<E> implements Serializable {

    private LinkedStack<Website> stack = new LinkedStack<Website>();

    public void addWebsite(String date, String url, String title, String Time) {
        Website website = new Website(url, date, title, Time);
        stack.push(website);
        System.out.println("Website added");


//        LinkedStack<Website> tmpStack = new LinkedStack<>();
//        while (!stack.isEmpty()) {
//            System.out.println(stack.top());
//            tmpStack.push(stack.pop());
//        }
//        while (!tmpStack.isEmpty()) {
//            stack.push(tmpStack.pop());
//        }

    }

    public boolean displayAllWebsites() {
        boolean found = false;
        LinkedStack<Website> tmpStack = new LinkedStack<>();
        while (!stack.isEmpty()) {
            found = true;
            Website tmpWeb = stack.pop();
            tmpStack.push(tmpWeb);
            System.out.println(tmpWeb.toString());
        }
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
        return found;
    }

    public int SearchWebsite(String targetUrl) {
        LinkedStack<Website> tmpStack = stack;
        int count = 0;
        while (!tmpStack.isEmpty()) {
            Website current = tmpStack.pop();
            if (current.getUrl().equalsIgnoreCase(targetUrl)) {
                System.out.println("Date:  " + current.getDate() + "  ,Time: " + current.getTime());
                count++;
            }
        }
        return count;

    }

    public void deleteWebsite(String targetUrl) {
        LinkedStack<Website> tmpStack = new LinkedStack<>();
        boolean found = false;
        while (!stack.isEmpty() && !found) {
            Website current = stack.pop();
            if (current.getUrl().equalsIgnoreCase(targetUrl)) {
                found = true;
                System.out.println("The Website has been deleted");
            } else tmpStack.push(current);
        }
        if (!found) System.out.println("This website doesn't exist on this date");
        while (!tmpStack.isEmpty()) stack.push(tmpStack.pop());
    }
}
