package composition;

public class MailerBox implements Box {

	@Override
	public void pack() {
		System.out.println("pack box");
	}

	@Override
	public void seal() {
		System.out.println("seal box");
	}

	public void addPostage() {
		System.out.println("affix stamps");
	}

	public void ship() {
		System.out.println("put in mailbox");
	}

}
